#include "First.h"
#include <string.h>
#include <stdlib.h>

const char* VoidSymbol = "$"; // "ε"

char rule_table_ci[20][256];
char ruleNameArr[20][64];
void FreeRule(Rule* pRule)
{
	while (pRule != NULL)
	{
		RuleSymbol* pRuleSymbol = pRule -> pFirstSymbol;
		while (pRuleSymbol != NULL)
		{
			RuleSymbol* pTemp = pRuleSymbol;
			pRuleSymbol = pRuleSymbol -> pNextSymbol;
			free(pTemp);
		}
		Rule* pTemp = pRule;
		pRule = pRule -> pNextRule;
		free(pTemp);
	}
}
int main(int argc, char* argv[])
{
	//
	// 调用 InitRules 函数初始化文法
	//
#ifdef CODECODE_CI
	Rule* pHead = InitRules_CI();  	// 此行代码在线上流水线运行
#else
	Rule* pHead = InitRules();		// 此行代码在 CP Lab 中运行
#endif
	
	//
	// 输出文法
	//
	PrintRule(pHead);
	
	//
	// 调用 First 函数求文法的 First 集合
	//
	SetList FirstSet;
	FirstSet.nSetCount = 0;
	First(pHead, &FirstSet);
	
	//
	// 输出First集合
	// 
	PrintFirstSet(&FirstSet);
	FreeRule(pHead);
	return 0;
}

/*
功能：
	添加一个 Set 到 SetList。

参数：
	pSetList -- SetList 指针。
	pName -- 集合名称字符串指针。 
*/
void AddOneSet(SetList* pSetList, const char* pName)
{
	//将源 Set 中的所有终结符添加到目标 Set 中
	if (GetSet(pSetList, pName) != NULL)
	{
		return;//已有，返回
	}	
	else
	{// 没有
		strcpy(pSetList->Sets[pSetList->nSetCount].Name, pName);
		pSetList->Sets[pSetList->nSetCount++].nTerminalCount = 0;
	}
	//
	// TODO: 在此添加代码
	//
	
}

/*
功能：
	根据名称在 SetList 中查找 Set。

参数：
	pSetList -- SetList 指针。
	pName -- 集合名称字符串指针。
	  
返回值：
	如果找到返回 Set 的指针，否则返回 NULL。
*/
Set* GetSet(SetList* pSetList, const char* pName)
{
	int i=0;
	for (;i<pSetList->nSetCount;i++)
	{
		if (strcmp(pSetList -> Sets[i].Name, pName) == 0)//遍历setlist
		{
			return &pSetList -> Sets[i];
		}	
	}
	return NULL;
	//
	// TODO: 在此添加代码
	//
	
}

/*
功能：
	添加一个终结符到 Set。

参数：
	pSet -- Set 指针。
	pTerminal -- 终结符名称指针。
	  
返回值：
	添加成功返回 1。
	添加不成功返回 0。
*/
int AddTerminalToSet(Set* pSet, const char* pTerminal)
{
	int i=0;
	// 查找是否有Terminal
	for (; i < pSet -> nTerminalCount; i++)
	{
		if (strcmp(pTerminal, pSet -> Terminal[i])==0)//有
		{
			return 0;
		}	
	}
	// 没有：添加进集合
	strcpy(pSet -> Terminal[pSet -> nTerminalCount++], pTerminal);
	return 1;
	//
	// TODO: 在此添加代码
	//
	
}

/*
功能：
	将源 Set 中的所有终结符添加到目标 Set 中。

参数：
	pDesSet -- 目标 Set 指针。
	pSrcSet -- 源 Set 指针。
	  
返回值：
	添加成功返回 1，否则返回 0。
*/
int AddSetToSet(Set* pDesSet, const Set* pSrcSet)
{
	int i;
	for (i = 0; i < pSrcSet->nTerminalCount; i++)
	{	
		//插入	
		if (AddTerminalToSet(pDesSet, pSrcSet->Terminal[i]) == 0)// 如果插入失败
		{
			return 0;
		}	
	}
	return 1;
	//
	// TODO: 在此添加代码
	//
	
}

/*
功能：
	判断 Set 的终结符中是否含有ε。

参数：
	pSet -- Set 指针。
	  
返回值：
	存在返回 1。
	不存在返回 0。
*/
int SetHasVoid(const Set* pSet)
{
	int i;
	for (i = 0; i < pSet->nTerminalCount; i++)
	{		
		if (strcmp(pSet->Terminal[i], VoidSymbol) == 0)// 当前的终结符为ε
		{
			return 1;
		}	
	}
	return 0;	
	//
	// TODO: 在此添加代码
	//
			
}

/*
功能：
	求文法的 First 集合。

参数：
	pHead -- 文法的头指针。
	pFirstSetList -- First 集合指针。
*/
void First(const Rule* pHead, SetList* pFirstSetList)
{
	const Rule* pRule;  // Rule 指针
	int isChange;	    // 集合是否被修改的标志
	RuleSymbol* pSymbol;// Symbol 游标

	// 使用文法链表初始化 First 集合
	for (pRule = pHead; pRule != NULL; pRule = pRule->pNextRule)
	{
		AddOneSet(pFirstSetList, pRule->RuleName);
	}

	do
	{
		isChange = 0; // 设置修改标志

		for (pRule = pHead; pRule != NULL; pRule = pRule->pNextRule)
		{
			// 根据文法名称在 pFirstSetList 中查找 Set
			Set* pDesSet = GetSet(pFirstSetList, pRule->RuleName);

			int hasVoid = 1; // First 集合中是否含有ε的标志
			for (pSymbol = pRule->pFirstSymbol; 
			pSymbol != NULL && hasVoid; 
			pSymbol = pSymbol->pNextSymbol)
			{
				if (pSymbol->isToken)	// 终结符
				{
					// 调用 AddTerminalToSet 函数将终结符添加到 pDesSet，并设置修改标志
					if (AddTerminalToSet(pDesSet, pSymbol->SymbolName))
					{
						isChange = 1;
					}	

					hasVoid = 0; // 设置 First 集合中是否含有ε的标志
				}
				else	// 非终结符
				{
					// 根据非终结符名称在 pFirstSetList 中查找 Set
					Set* pSrcSet = GetSet(pFirstSetList, pSymbol->SymbolName);

					// 调用 AddSetToSet 函数，将源 Set 中的所有终结符添加到目标 Set 中，并设置修改标志
					if (AddSetToSet(pDesSet, pSrcSet))
					{
						isChange = 1;
					}
						

					// 调用 SetHasVoid 函数，判断源 Set 中是否含有ε
					hasVoid = SetHasVoid(pSrcSet);
				}
			}
			if (hasVoid)
			{
				// 调用 AddTerminalToSet 函数将ε加入到目标集合中
				AddTerminalToSet(pDesSet, VoidSymbol);
			}
		}
	} while (isChange);
	
}

typedef struct _SYMBOL
{
	int isToken;
	char SymbolName[MAX_STR_LENGTH];
}SYMBOL;

typedef struct _RULE_ENTRY
{
	char RuleName[MAX_STR_LENGTH];
	SYMBOL Symbols[64];
}RULE_ENTRY;

static const RULE_ENTRY rule_table[] =
{
	/* exp -> exp addop term| term */
	{ "exp", { { 0, "exp" }, { 0, "addop"}, { 0, "term"} } },
	{ "exp", { { 0, "term" } } },

	/* addop -> + | - */
	{ "addop", { { 1, "+" } } },
	{ "addop", { { 1, "-" } } },

	/* term -> term mulop factor | factor */
	{ "term", { { 0, "term" }, { 0, "mulop"}, { 0, "factor"} } },
	{ "term", { { 0, "factor" } } },

	/* mulop -> * */
	{ "mulop", { { 1, "*" } } },

	/* factor -> (exp) | number */
	{ "factor", { { 1, "(" }, { 0, "exp"}, { 1, ")"} } },
	{ "factor", { { 1, "number" } } },
};

/*
功能：
	初始化文法链表。
	
返回值：
	文法的头指针。
*/
Rule* InitRules()
{
	Rule *pHead, *pRule;
	int nRuleCount = sizeof(rule_table) / sizeof(rule_table[0]);
	int i, j;

	Rule** pRulePtr = &pHead;
	for (i=0; i<nRuleCount; i++)
	{
		*pRulePtr = CreateRule(rule_table[i].RuleName);
		pRulePtr = &(*pRulePtr)->pNextRule;
	}

	pRule = pHead;
	for (i=0; i<nRuleCount; i++)
	{
		RuleSymbol **pSymbolPtr;
		pSymbolPtr = &pRule->pFirstSymbol;
		for (j=0; rule_table[i].Symbols[j].SymbolName[0] != '\0'; j++)
		{
			RuleSymbol *pNewSymbol;
			const SYMBOL* pSymbol = &rule_table[i].Symbols[j];

			pNewSymbol = CreateSymbol();
			pNewSymbol->isToken = pSymbol->isToken;
			strcpy(pNewSymbol->SymbolName, pSymbol->SymbolName);
			*pSymbolPtr = pNewSymbol;

			pSymbolPtr = &pNewSymbol->pNextSymbol;
		}

		pRule = pRule->pNextRule;
	}

	return pHead;
}

/*
功能：
	初始化文法链表(在执行流水线时调用)。
	
返回值：
	文法的头指针。
*/
Rule* InitRules_CI()
{
	int nRuleCount = 0;
	// 需要读取多行文本
	for (int i = 0; i < 20; i++)
	{
		gets(rule_table_ci[i]);	
		int length = strlen(rule_table_ci[i]);
		if (length == 0)
		{
			break;
		}
		
		for (int j = 0; j < length; j++)
		{
			if (rule_table_ci[i][j] == ' ')
			{
				ruleNameArr[i][j] = '\0';
				break;
			}
			ruleNameArr[i][j]= rule_table_ci[i][j];
		}	  
		nRuleCount++;
	}
	
	Rule *pHead, *pRule;

	Rule** pRulePtr = &pHead;
	for (int i=0; i<nRuleCount; i++)
	{
		*pRulePtr = CreateRule(ruleNameArr[i]);
		pRulePtr = &(*pRulePtr)->pNextRule;
	}

	pRule = pHead;
	for (int i=0; i<nRuleCount; i++)
	{
		RuleSymbol **pSymbolPtr;
		pSymbolPtr = &pRule->pFirstSymbol;
		
		int start = 0;
		for (int j=0; rule_table_ci[i][j] != '\0'; j++)
		{
			if (rule_table_ci[i][j] == ' '
			 && rule_table_ci[i][j + 1] == '-'
			&& rule_table_ci[i][j + 2] == '>' 
			&& rule_table_ci[i][j + 3] == ' ')
			{
				start = j + 4;
				break;
			}
		}
			
		for (int k=start; rule_table_ci[i][k] != '\0'; k++)
		{
			RuleSymbol *pNewSymbol;
			if (rule_table_ci[i][k] == ' ')
			{
				continue;
			}
				
			pNewSymbol = CreateSymbol();
			char tokenName[MAX_STR_LENGTH] = {};
			
			for (int m = 0; ;m++)
			{
				if (rule_table_ci[i][k] ==  ' ' || rule_table_ci[i][k] == '\0' || rule_table_ci[i][k] == '\n')
				{
					tokenName[m] = '\0';
					break;
				}
				tokenName[m] = rule_table_ci[i][k++];
				
			}
			
			
			strcpy(pNewSymbol->SymbolName, tokenName);
			
			pNewSymbol->isToken = 1;
			for (int n = 0; n < nRuleCount; n++)
			{
				if (strcmp(pNewSymbol->SymbolName, ruleNameArr[n]) == 0)
				{
					pNewSymbol->isToken = 0;
					break;
				}
			}		
			
			*pSymbolPtr = pNewSymbol;

			pSymbolPtr = &pNewSymbol->pNextSymbol;
			
		}
			
		pRule = pRule->pNextRule;
	}

	return pHead;
}

/*
功能：
	创建一个新的文法。
	
参数：
	pRuleName -- 文法的名字。	
	
返回值：
	文法的指针。
*/
Rule* CreateRule(const char* pRuleName)
{
	Rule* pRule = (Rule*)malloc(sizeof(Rule));

	strcpy(pRule->RuleName, pRuleName);
	pRule->pFirstSymbol = NULL;
	pRule->pNextRule = NULL;

	return pRule;
}

/*
功能：
	创建一个新的符号。
	
返回值：
	符号的指针。
*/
RuleSymbol* CreateSymbol()
{
	RuleSymbol* pSymbol = (RuleSymbol*)malloc(sizeof(RuleSymbol));

	pSymbol->pNextSymbol = NULL;
	pSymbol->isToken = -1;
	pSymbol->SymbolName[0] = '\0';

	return pSymbol;
}

/*
功能：
	输出文法。
	
参数：
	pHead -- 文法的头指针。
*/
void PrintRule(const Rule* pHead)
{
	const Rule* pRule;
	for (pRule = pHead; pRule != NULL; pRule = pRule->pNextRule)
	{
		printf("%s ->", pRule->RuleName);

		RuleSymbol* pRuleSymbol;
		for (pRuleSymbol = pRule->pFirstSymbol; pRuleSymbol != NULL; 
			pRuleSymbol = pRuleSymbol->pNextSymbol)
		{	
			printf(" %s", pRuleSymbol->SymbolName);
		}
		printf("\n");
	}
}

/*
功能：
	输出 First 集合。

参数：
	pFirstSetList -- First 集合指针。
*/
void PrintFirstSet(SetList* pFirstSetList)
{
	printf("\nThe First Set:\n");
	for (int i = 0; i < pFirstSetList->nSetCount; i++)
	{
		printf("First(%s) = { ", pFirstSetList->Sets[i].Name);
		for (int j = 0; j < pFirstSetList->Sets[i].nTerminalCount; j++)
		{
			if (j == pFirstSetList->Sets[i].nTerminalCount - 1)
			{
				printf("%s ", pFirstSetList->Sets[i].Terminal[j]);
			}
			else
			{
				printf("%s, ", pFirstSetList->Sets[i].Terminal[j]);
			}
			
		}
		printf("}\n");
	}
}

