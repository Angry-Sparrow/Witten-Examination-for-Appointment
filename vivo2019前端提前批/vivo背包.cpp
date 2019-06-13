#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>
#include <vector>
#include <sstream>
#include <math.h>
#include <stdlib.h>	
#define  ARRAY_MAX 101
#define  ROW_MAX 1001
int max(int a,int b)
{
	if(a > b)
	{
		return a;
	}
	return b;
}
int findBest(int prices[],int vals[],int len,int total)
{
	int re = 0;
	int* p = new int[len+1];
	int* v = new int[len+1];
	p[0] = 0;
	v[0] = 0;
	for (int i = 1;i < len+1;i++)
	{
		p[i] = prices[i-1];
		v[i] = vals[i-1];
	}
	int f[ARRAY_MAX][ROW_MAX] = {0};
	for (int i = 1; i <= len; i++) {
		for (int j = 1; j <= total; j++) {
			if (p[i] > j) {
				f[i][j] = f[i - 1][j];
			}
			else {
				f[i][j] = f[i - 1][j] > f[i - 1][j - p[i]] + v[i] ? f[i - 1][j] : f[i - 1][j - p[i]] + v[i];
			}
		}
	} 
	re = f[len][total];
	return  re;
}
int main()
{	
	int t = 1000;
	int price[6] = {200,600,100,180,300,450};
	//int price[6] = {100,180,200,300,450,600};
	int r[6] = {6,10,3,4,5,8};	
	std::cout<<findBest(price,r,6,t);
	return 0;
}