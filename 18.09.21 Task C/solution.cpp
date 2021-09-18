// То же самый алгоритм, что и на Java. Проходит на 1 больше тест, чем Java, после чего утыкается в ограничение времени.

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class MyClass {
    public:
        long long int value;
        int index;
    MyClass(int v, int i) {
        value = v;
        index = i;
    }
};

bool comparator(MyClass a, MyClass b) {
    return a.value < b.value;
}


int main(int argc, char const *argv[])
{
    int n, k;
    cin >> n >> k;
    vector<MyClass> arr;

    for(int i = 0; i < n; i++) {
        int t;
        cin >> t;
        MyClass temp(t, i);
        arr.push_back(temp);
    }
    sort(arr.begin(), arr.end(), comparator);

    int index = -1;
    int nowValue = -1;
    int deltaR, deltaL;
    vector<int> result(n, 0);

    for(int i = 0; i < n; i++) {
        nowValue = arr[i].value;
        index = arr[i].index;

        deltaR = 1;
        deltaL = 1;
        for(int j = 0; j < k; j++) {
            if (i - deltaL < 0) {
                
                result[index] += arr[i + deltaR].value - nowValue;
                int t = result[index];
                deltaR++;
                continue;
            }

            if ((i + deltaR > n - 1) || (nowValue - arr[i - deltaL].value <= arr[i + deltaR].value - nowValue)) {
                result[index] += nowValue - arr[i - deltaL].value;
                int t = result[index];
                deltaL++;
            }
            else {
                result[index] += arr[i + deltaR].value - nowValue;
                int t = result[index];
                deltaR++;
            }
        }
    }

    for(int now : result) {
        cout << now << " ";
    }

    
    return 0;
}
