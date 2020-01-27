
arr1=[2,42,13,67,34,255,7,-2,-2,1,13,55]


def partition(arr,start,end,pivot):
    i=start
    j=start-1
    while i<end-1:
        if arr[i]<arr[pivot] :
            j = j + 1
            arr[j],arr[i]=arr[i],arr[j]
        i+=1

    arr[j+1],arr[pivot]=arr[pivot],arr[j+1]

    return j+1


def quickSort(arr,start,end):

    if start<end-1:
        pivot=end-1
        pivot_pos=partition(arr,start,end,pivot)
        quickSort(arr,start,pivot_pos)
        quickSort(arr,pivot_pos+1,end)


quickSort(arr1,0,len(arr1))
print(arr1)
