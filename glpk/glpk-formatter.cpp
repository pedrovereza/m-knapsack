#include <stdio.h>
#include <iostream>

using namespace std;

#define MAX_DIMENSIONS 1000
#define MAX_ITEMS 1000

int itemSizePerDimension[MAX_ITEMS][MAX_DIMENSIONS];
int itemValues[MAX_ITEMS];
int knapsack[MAX_DIMENSIONS];

int main() {
    
    int itemCount, dimensionCount, optimalResult;
    
    cin >> itemCount >> dimensionCount >> optimalResult;
    
    for (int i = 0; i < itemCount; ++i) {
        cin >> itemValues[i];
    }
    
    for (int j = 0; j < dimensionCount; ++j) {
        for (int i = 0; i < itemCount; ++i) {
            cin >> itemSizePerDimension[i][j];
        }
    }
    
    for (int i = 0; i < dimensionCount; ++i) {
        cin >> knapsack[i];
    }
    
    cout << "set dimensions :=";
    for (int i = 1; i <= dimensionCount; ++i) cout << " " << i;
    cout << ";" << endl;
    
    cout << "set items :=";
    for (int i = 1; i <= itemCount; ++i) cout << " " << i;
    cout << ";" << endl;
    
    cout << "param capacity :=";
    for (int i = 0; i < dimensionCount; ++i) {
        cout << " " << i + 1 << " " << knapsack[i];
    }
    cout << ";" << endl;
    
    cout << "param itemValue :=";
    for (int i = 0; i < itemCount; ++i) {
        cout << " " << i + 1 << " " << itemValues[i];
    }
    cout << ";" << endl;
    
    cout << "param itemSizeInDimension :=";
    for (int i = 0; i < itemCount; ++i) {
        for (int j = 0; j < dimensionCount; ++j) {
            cout << " " << i + 1 << " " << j + 1 << " " << itemSizePerDimension[i][j];
        }
    }
    cout << ";" << endl;
    
    return 0;
}
