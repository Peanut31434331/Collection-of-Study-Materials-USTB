#include "RemoveLeftRecursion.h"
#include <string.h>
#include <stdlib.h>

const char* VoidSymbol = "$"; // "ε"
const char* Postfix = "'";

char rule_table_ci[20][256];
char ruleNameArr[20][64];


//之前看它没用到就把它删了...呜呜
void FreeSelect(RuleSymbol* pSelect)
{
	RuleSymbol* pSymbol = pSelect;
	while (pSymbol != NULL)
	{//遍历所有
		RuleSymbol* pTemp = pSymbol;
		pSymbol = pSymbol -> pNextSymbol;
		free(pTemp);
	}
	//
	// TODO: 在此添加代码
	//

}
void FreeRule(Rule* pRule)
{
	if (pRule==NULL) 
	{
	   return;//删完了
	}
    FreeRule(pRule->pNextRule);
	RuleSymbol *pCurSelect=pRule->pFirstSymbol, *pNxtSelect;
	while (pCurSelect)
	{
		pNxtSelect=pCurSelect->pOther;
		FreeSelect(pCurSelect);
		pCurSelect=pNxtSelect;
	}
	free(pRule);
    return;
}
int main(int argc, char* argv[])
{
	//
	// 调用 InitRules 函数初始化文法
	//	
#ifdef CODECODE_CI
	Rule* pHead = InitRules_CI(); 	// 此行代码在线上流水线运行
#else
	Rule* pHead = InitRules();		// 此行代码在 CP Lab 中运行
#endif

	//
	// 输出消除左递归之前的文法
	//
	printf("Before Remove Left Recursion:\n");
	PrintRule(pHead);

	//
	// 调用 RemoveLeftRecursion 函数对文法消除左递归
	//
	RemoveLeftRecursion(pHead);
	
	//
	// 输出消除左递归之后的文法
	//
	printf("\nAfter Remove Left Recursion:\n");
	PrintRule(pHead);
	
	FreeRule(pHead);
	return 0;
}

/*
功能：
	将一个 Symbol 添加到 Select 的末尾。

参数：
	pSelect -- Select 指针。
	pNewSymbol -- Symbol 指针。
*/
void AddSymbolToSelect(RuleSymbol* pSelect, RuleSymbol* pNewSymbol)
{
	while (pSelect->pNextSymbol!=NULL)
	{ 
		pSelect=pSelect->pNextSymbol;
	}
	pSelect->pNextSymbol=pNewSymbol;
	//return ;
	//
	// TODO: 在此添加代码
	//
	
	
}

/*
功能：
	将一个 Select 加入到文法末尾。当 Select 为 NULL 时就将一个ε终结符加入到文法末尾。

参数：
	pRule -- 文法指针。
	pNewSelect -- Select 指针。
*/
void AddSelectToRule(Rule* pRule, RuleSymbol* pNewSelect)
{
	RuleSymbol* pTempSelect = pRule -> pFirstSymbol;
	if (pTempSelect == NULL)
	{//空则直接加上
		pRule -> pFirstSymbol = pNewSelect;
		return; 
	}
	// 到select链表尾部
	while (pTempSelect -> pOther != NULL)
	{
		pTempSelect = pTempSelect -> pOther;
	}
	// 如果是NULL则添加空字符终结符
	if (pNewSelect == NULL)
	{
		pNewSelect = (RuleSymbol*)malloc(sizeof(RuleSymbol));
		pNewSelect -> pNextSymbol = NULL;
		pNewSelect -> pOther = NULL;
		pNewSelect -> isToken = 1;
		strcpy(pNewSelect -> TokenName, VoidSymbol);
	}
	// 将新的select添加到Rule末尾
	pTempSelect -> pOther = pNewSelect;
	//
	// TODO: 在此添加代码
	//
	
}

/*
功能：
	消除左递归。

参数：
	pHead -- 文法链表的头指针。
*/
void RemoveLeftRecursion(Rule* pHead)
{
	RuleSymbol* pSelect; // Select 游标
	Rule* pNewRule;  	 // Rule 指针
	
	pNewRule = CreateRule(pHead->RuleName); // 创建新 Rule
	strcat(pNewRule->RuleName, Postfix);

	pSelect = pHead->pFirstSymbol; // 初始化 Select 游标
	RuleSymbol **pSelectPrePtr = &pHead->pFirstSymbol;
	RuleSymbol*temp;
	while (pSelect != NULL) // 循环处理所有的 Select
	{
		if (0 == pSelect->isToken && pSelect->pRule == pHead)// Select 存在左递归
		{
			// 移除包含左递归的 Select，将其转换为右递归后添加到新 Rule 的末尾，并移动游标
			
            RuleSymbol* pNewSymbol=CreateSymbol();//A'
            pNewSymbol->isToken=0;
            pNewSymbol->pRule=pNewRule;
            
            RuleSymbol* pns=pSelect->pNextSymbol;
            AddSymbolToSelect(pns, pNewSymbol);
            AddSelectToRule(pNewRule, pns);
            
            
            (*pSelectPrePtr)=pSelect->pOther;
            
            if (pSelect->pOther!=NULL)
            {
            	pSelect = pSelect->pOther;
            }
            else 
            {
           	 	temp->pOther=NULL;
            	break;
            }
			//
			// TODO: 在此添加代码
			//
			
		}
		else // Select 不存在左递归
		{
			// 在没有左递归的 Select 末尾添加指向新 Rule 的非终结符，并移动游标  
			RuleSymbol* pns=CreateSymbol();
            pns->isToken=0;
            pns->pRule=pNewRule;
			AddSymbolToSelect(pSelect, pns);
			temp=pSelect;
			pSelect=pSelect->pOther;
            pSelectPrePtr=pSelect;
			
			//
			// TODO: 在此添加代码
			//
			
		}
	}

	// 在新 Rule 的最后加入ε(用 '$' 代替)
	// 将新 Rule 插入文法链表
	
	AddSelectToRule(pNewRule, NULL);
    Rule* pp=pHead;
    while (pp->pNextRule!=NULL) 
    {  
        pp=pp->pNextRule;
    }
    pp->pNextRule=pNewRule;
	//
	// TODO: 在此添加代码
	//
	
	return;
}

/*
功能：
	使用给定的数据初始化文法链表

返回值：
	Rule 指针
*/
typedef struct _SYMBOL
{
	int isToken;
	char Name[MAX_STR_LENGTH];
}SYMBOL;

typedef struct _RULE_ENTRY
{
	char RuleName[MAX_STR_LENGTH];
	SYMBOL Selects[64][64];
}RULE_ENTRY;

static const RULE_ENTRY rule_table[] =
{
	/* A -> Aa | bA | c | Ad */
	{ "A", 
			{
				{ { 0, "A" }, { 1, "a" } },
				{ { 1, "b" }, { 0, "A" } },
				{ { 1, "c" } },
				{ { 0, "A" }, { 1, "d" } }
			}
	}
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
	RuleSymbol **pSymbolPtr1, **pSymbolPtr2;
	int nRuleCount = sizeof(rule_table) / sizeof(rule_table[0]);
	int i, j, k;

	Rule** pRulePtr = &pHead;
	for (i=0; i<nRuleCount; i++)
	{
		*pRulePtr = CreateRule(rule_table[i].RuleName);
		pRulePtr = &(*pRulePtr)->pNextRule;
	}

	pRule = pHead;
	for (i=0; i<nRuleCount; i++)
	{
		pSymbolPtr1 = &pRule->pFirstSymbol;
		for (j=0; rule_table[i].Selects[j][0].Name[0] != '\0'; j++)
		{
			pSymbolPtr2 = pSymbolPtr1;
			for (k=0; rule_table[i].Selects[j][k].Name[0] != '\0'; k++)
			{
				const SYMBOL* pSymbol = &rule_table[i].Selects[j][k];

				*pSymbolPtr2 = CreateSymbol();
				(*pSymbolPtr2)->isToken = pSymbol->isToken;
				if (1 == pSymbol->isToken)
				{
					strcpy((*pSymbolPtr2)->TokenName, pSymbol->Name);
				}
				else
				{
					(*pSymbolPtr2)->pRule = FindRule(pHead, pSymbol->Name);
					if (NULL == (*pSymbolPtr2)->pRule)
					{
						printf("Init rules error, miss rule \"%s\"\n", pSymbol->Name);
						exit(1);
					}
				}
				
				pSymbolPtr2 = &(*pSymbolPtr2)->pNextSymbol;
			}
			
			pSymbolPtr1 = &(*pSymbolPtr1)->pOther;
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
	/* A -> Aa | bA | c | Ad */

	int nRuleCount = 0;
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
	RuleSymbol **pSymbolPtr1, **pSymbolPtr2;
		
	int i, k;

	Rule** pRulePtr = &pHead;
	for (i=0; i<nRuleCount; i++)
	{
		*pRulePtr = CreateRule(ruleNameArr[i]);
		pRulePtr = &(*pRulePtr)->pNextRule;
	}

	pRule = pHead;
	for (i=0; i<nRuleCount; i++)
	{
		pSymbolPtr1 = &pRule->pFirstSymbol;
		
		int start = 0;
		for (int j = 0; rule_table_ci[i][j] != '\0'; j++)
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
			
		for (k = start; rule_table_ci[i][k] != '\0'; k++)
		{
			if (rule_table_ci[i][k] == '|')
			{
				pSymbolPtr1 = &(*pSymbolPtr1)->pOther;
				pSymbolPtr2 = pSymbolPtr1;
				continue;
			}
			if (rule_table_ci[i][k] == ' ')
			{
				continue;
			}
			if (k == start)
			{
				pSymbolPtr2 = pSymbolPtr1;
			}

			*pSymbolPtr2 = CreateSymbol();
			
			char tokenName[MAX_STR_LENGTH] = {};
			tokenName[0] = rule_table_ci[i][k];
			tokenName[1] = '\0';
			(*pSymbolPtr2)->isToken = 1;
			for (int m = 0; m < nRuleCount; m++)
			{
				if (strcmp(tokenName, ruleNameArr[m]) == 0)
				{
					(*pSymbolPtr2)->isToken = 0;
					(*pSymbolPtr2)->pRule = FindRule(pHead, tokenName);
					if (NULL == (*pSymbolPtr2)->pRule)
					{
						printf("Init rules error, miss rule \"%s\"\n", tokenName);
						exit(1);
					}
				}
			}
			if ((*pSymbolPtr2)->isToken == 1)
			{
				strcpy((*pSymbolPtr2)->TokenName, tokenName);
			}
			
			pSymbolPtr2 = &(*pSymbolPtr2)->pNextSymbol;
			
		}
			
		pRule = pRule->pNextRule;
	}

	return pHead;
}


/*
功能：
	创建一个新的 Rule。

参数：
	pRuleName -- 文法的名字。
	
返回值：
	Rule 指针	
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
	创建一个新的 Symbol。
	
返回值：
	RuleSymbol 指针	
*/
RuleSymbol* CreateSymbol()
{
	RuleSymbol* pSymbol = (RuleSymbol*)malloc(sizeof(RuleSymbol));

	pSymbol->pNextSymbol = NULL;
	pSymbol->pOther = NULL;
	pSymbol->isToken = -1;
	pSymbol->TokenName[0] = '\0';
	pSymbol->pRule = NULL;

	return pSymbol;
}

/*
功能：
	根据 RuleName 在文法链表中查找名字相同的文法。

参数：
	pHead -- 文法链表的头指针。
	RuleName -- 文法的名字。
	
返回值：
	如果存在名字相同的文法返回 Rule 指针，否则返回 NULL	
*/
Rule* FindRule(Rule* pHead, const char* RuleName)
{
	Rule* pRule;
	for (pRule = pHead; pRule != NULL; pRule = pRule->pNextRule)
	{
		if (0 == strcmp(pRule->RuleName, RuleName))
		{
			break;
		}
	}
	
	return pRule;
}	

/*
功能：
	输出文法。

参数：
	pHead -- 文法链表的头指针。
*/
void PrintRule(Rule* pHead)
{
	Rule* p=pHead;
    while (p!=NULL)
    {
        printf("%s->", p->RuleName);
        RuleSymbol *pp=p->pFirstSymbol;
        while (pp!=NULL)
        {
            RuleSymbol *temp=pp;
            while (temp!=NULL)
            {
                printf("%s", temp->isToken?temp->TokenName:temp->pRule->RuleName);
                temp=temp->pNextSymbol;
            }
            pp=pp->pOther;
            if (pp) 
            {
               printf("%s", "|");
            }
        }
        printf("\n");
        p=p->pNextRule;
    }
	//
	// TODO: 在此添加代码
	//
	
}

