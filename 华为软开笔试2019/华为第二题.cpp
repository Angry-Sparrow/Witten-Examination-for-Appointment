#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
/*
 这个题我本地2012的编译器会报错，但牛客上100%通过率 c++11  很迷
*/
int main()
{
	int low, high;
	cin >> low>> high;
	int j,k;
	vector<int> nums;
	int sum1 = 0;
	int sum2 = 0;
	for (int i = low;i < high; ++i)
	{
		k = (int)sqrt(i);
		for (j = 2; j <= k; ++j)
		{
			if (i % j == 0)
			{
				break;
			}
		}
		if (j >= k + 1)
		{
			nums.push_back(i);
		}
	}

 	for (int i = 0; i < nums.size(); ++i)
	{
		int tmp = nums[i];
		int j = 0;
		if(tmp)
		{
			int k = tmp % 10;
			sum1 += k;
			tmp /= 10;
		}
		if (tmp!=0)
		{
			int k = tmp % 10;
			sum2 += k;
		}
		else
		{
			sum2 += 0;
		}
	}
	if (sum1 < sum2)
	{
		cout << sum1 << endl;
	}
	else
	{
		cout << sum2 << endl;
	}
	//system("pause");
	return 0;
}