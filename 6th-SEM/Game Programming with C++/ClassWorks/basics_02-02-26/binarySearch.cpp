//write a prog for Binary Search
#include <iostream>
using namespace std;

int main() {
    int arr[] = {1, 2, 3, 4, 5};
    int n = sizeof(arr) / sizeof(arr[0]);
    int search;

    cout << "Enter element to search: ";
    cin >> search;

    int i = 0, j = n - 1;
    bool found = false;

    while (i <= j) {
        int mid = (i + j) / 2;

        if (arr[mid] == search) {
            cout << "Element found at index " << mid;
            found = true;
            break;
        }
        else if (search < arr[mid]) {
            j = mid - 1;
        }
        else {
            i = mid + 1;
        }
    }

    if (!found) {
        cout << "Element not found";
    }

    return 0;
}

