#include "First.h"
#include <string.h>
#include <stdlib.h>

const char* VoidSymbol = "$"; // "��"

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
	// ���� InitRules ������ʼ���ķ�
	//
#ifdef CODECODE_CI
	Rule* pHead = InitRules_CI();  	// ���д�����������ˮ������
#else
	Rule* pHead = InitRules();		// ���д����� CP Lab ������
#endif
	
	//
	// ����ķ�
	//
	PrintRule(pHead);
	
	//
	// ���� First �������ķ��� First ����
	//
	SetList FirstSet;
	FirstSet.nSetCount = 0;
	First(pHead, &FirstSet);
	
	//
	// ���First����
	// 
	PrintFirstSet(&FirstSet);
	FreeRule(pHead);
	return 0;
}

/*
���ܣ�
	���һ�� Set �� SetList��

������
	pSetList -- SetList ָ�롣
	pName -- ���������ַ���ָ�롣 
*/
void AddOneSet(SetList* pSetList, const char* pName)
{
	//��Դ Set �е������ս����ӵ�Ŀ�� Set ��
	if (GetSet(pSetList, pName) != NULL)
	{
		return;//���У�����
	}	
	else
	{// û��
		strcpy(pSetList->Sets[pSetList->nSetCount].Name, pName);
		pSetList->Sets[pSetList->nSetCount++].nTerminalCount = 0;
	}
	//
	// TODO: �ڴ���Ӵ���
	//
	
}

/*
���ܣ�
	���������� SetList �в��� Set��

������
	pSetList -- SetList ָ�롣
	pName -- ���������ַ���ָ�롣
	  
����ֵ��
	����ҵ����� Set ��ָ�룬���򷵻� NULL��
*/
Set* GetSet(SetList* pSetList, const char* pName)
{
	int i=0;
	for (;i<pSetList->nSetCount;i++)
	{
		if (strcmp(pSetList -> Sets[i].Name, pName) == 0)//����setlist
		{
			return &pSetList -> Sets[i];
		}	
	}
	return NULL;
	//
	// TODO: �ڴ���Ӵ���
	//
	
}

/*
���ܣ�
	���һ���ս���� Set��

������
	pSet -- Set ָ�롣
	pTerminal -- �ս������ָ�롣
	  
����ֵ��
	��ӳɹ����� 1��
	��Ӳ��ɹ����� 0��
*/
int AddTerminalToSet(Set* pSet, const char* pTerminal)
{
	int i=0;
	// �����Ƿ���Terminal
	for (; i < pSet -> nTerminalCount; i++)
	{
		if (strcmp(pTerminal, pSet -> Terminal[i])==0)//��
		{
			return 0;
		}	
	}
	// û�У���ӽ�����
	strcpy(pSet -> Terminal[pSet -> nTerminalCount++], pTerminal);
	return 1;
	//
	// TODO: �ڴ���Ӵ���
	//
	
}

/*
���ܣ�
	��Դ Set �е������ս����ӵ�Ŀ�� Set �С�

������
	pDesSet -- Ŀ�� Set ָ�롣
	pSrcSet -- Դ Set ָ�롣
	  
����ֵ��
	��ӳɹ����� 1�����򷵻� 0��
*/
int AddSetToSet(Set* pDesSet, const Set* pSrcSet)
{
	int i;
	for (i = 0; i < pSrcSet->nTerminalCount; i++)
	{	
		//����	
		if (AddTerminalToSet(pDesSet, pSrcSet->Terminal[i]) == 0)// �������ʧ��
		{
			return 0;
		}	
	}
	return 1;
	//
	// TODO: �ڴ���Ӵ���
	//
	
}

/*
���ܣ�
	�ж� Set ���ս�����Ƿ��Цš�

������
	pSet -- Set ָ�롣
	  
����ֵ��
	���ڷ��� 1��
	�����ڷ��� 0��
*/
int SetHasVoid(const Set* pSet)
{
	int i;
	for (i = 0; i < pSet->nTerminalCount; i++)
	{		
		if (strcmp(pSet->Terminal[i], VoidSymbol) == 0)// ��ǰ���ս��Ϊ��
		{
			return 1;
		}	
	}
	return 0;	
	//
	// TODO: �ڴ���Ӵ���
	//
			
}

/*
���ܣ�
	���ķ��� First ���ϡ�

������
	pHead -- �ķ���ͷָ�롣
	pFirstSetList -- First ����ָ�롣
*/
void First(const Rule* pHead, SetList* pFirstSetList)
{
	const Rule* pRule;  // Rule ָ��
	int isChange;	    // �����Ƿ��޸ĵı�־
	RuleSymbol* pSymbol;// Symbol �α�

	// ʹ���ķ������ʼ�� First ����
	for (pRule = pHead; pRule != NULL; pRule = pRule->pNextRule)
	{
		AddOneSet(pFirstSetList, pRule->RuleName);
	}

	do
	{
		isChange = 0; // �����޸ı�־

		for (pRule = pHead; pRule != NULL; pRule = pRule->pNextRule)
		{
			// �����ķ������� pFirstSetList �в��� Set
			Set* pDesSet = GetSet(pFirstSetList, pRule->RuleName);

			int hasVoid = 1; // First �������Ƿ��Цŵı�־
			for (pSymbol = pRule->pFirstSymbol; 
			pSymbol != NULL && hasVoid; 
			pSymbol = pSymbol->pNextSymbol)
			{
				if (pSymbol->isToken)	// �ս��
				{
					// ���� AddTerminalToSet �������ս����ӵ� pDesSet���������޸ı�־
					if (AddTerminalToSet(pDesSet, pSymbol->SymbolName))
					{
						isChange = 1;
					}	

					hasVoid = 0; // ���� First �������Ƿ��Цŵı�־
				}
				else	// ���ս��
				{
					// ���ݷ��ս�������� pFirstSetList �в��� Set
					Set* pSrcSet = GetSet(pFirstSetList, pSymbol->SymbolName);

					// ���� AddSetToSet ��������Դ Set �е������ս����ӵ�Ŀ�� Set �У��������޸ı�־
					if (AddSetToSet(pDesSet, pSrcSet))
					{
						isChange = 1;
					}
						

					// ���� SetHasVoid �������ж�Դ Set ���Ƿ��Ц�
					hasVoid = SetHasVoid(pSrcSet);
				}
			}
			if (hasVoid)
			{
				// ���� AddTerminalToSet �������ż��뵽Ŀ�꼯����
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
���ܣ�
	��ʼ���ķ�����
	
����ֵ��
	�ķ���ͷָ�롣
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
���ܣ�
	��ʼ���ķ�����(��ִ����ˮ��ʱ����)��
	
����ֵ��
	�ķ���ͷָ�롣
*/
Rule* InitRules_CI()
{
	int nRuleCount = 0;
	// ��Ҫ��ȡ�����ı�
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
���ܣ�
	����һ���µ��ķ���
	
������
	pRuleName -- �ķ������֡�	
	
����ֵ��
	�ķ���ָ�롣
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
���ܣ�
	����һ���µķ��š�
	
����ֵ��
	���ŵ�ָ�롣
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
���ܣ�
	����ķ���
	
������
	pHead -- �ķ���ͷָ�롣
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
���ܣ�
	��� First ���ϡ�

������
	pFirstSetList -- First ����ָ�롣
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

