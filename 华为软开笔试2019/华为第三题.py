# 90% ͨ���ʣ�ʵ�ڲ�֪���������ﲻ�Ծ��ˡ�����з��ֵ������Ի����ʼ�����beqan2016@163.com

s = input().strip()
m = int(input())
c = [True]*m
g = {}
for i in range(m):
	g[i] = list(input().split(','))

def help(s,g):
	global c
	r = []
	for k,v in g.items():
		if s in v and c[k]:
			r += v
			c[k]=False
	rr = set(r)
	return list(rr)

if __name__ == "__main__":
	rr = help(s, g)
	res = rr
	j = 0
	while any(c) and j <= m:
		j = j+1
		for i in rr:
			temp = help(i, g)
			res += temp
		rr = temp

	res2 = set(res)
	print(res2)