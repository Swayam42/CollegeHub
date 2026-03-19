def selectionSort(l,n):
    for i in range(0,n-1):
        iMin=i
        for j in range(i+1,n):
            if (l[j]<l[iMin]):
                iMin=j
        temp=l[i]
        l[i]=l[iMin]
        l[iMin]=temp
    return l

def bubbleSort(A):
    n=len(A)
    for k in range(1,n):
        flag=0
        for i in range(0,n-k-1):
            if (A[i]>A[i+1]):
                temp=A[i]
                A[i]=A[i+1]
                A[i+1]=temp
                flag=1
        if flag==0:
            break
    return A

def insertionSort(B):
    n=len(B)
    for i in range(1,n-1):
        value=B[i]
        hole=i
        while(hole>0 and B[hole-1]>value):
            temp=B[hole]
            B[hole]=B[hole-1]
            B[hole-1]=temp
        B[hole]=value
    return B
    
def main():
    l=[3,5,1,2,5,4]
    n=len(l)
    print(selectionSort(l,n))
    print(bubbleSort(l))
    print(insertionSort(l))

if __name__=="__main__":
    main()