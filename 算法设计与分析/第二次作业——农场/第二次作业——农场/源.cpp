#include<iostream>
using namespace std;
int K;//��ΪK
int find(int n) {
	if (n <= K + 1)return 1;
	else if ((n - K) % 2 == 1)return 1;
	else return find((n - K) / 2) + find((n - K) / 2 + K);
}
int main() {
	int N;//Nͷţ
	cin >> N >> K;
	cout << find(N);
	return 0;
}