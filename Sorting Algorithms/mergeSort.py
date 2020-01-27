arr=[2,42,13,67,34,255,7,1,13,55]

def merge(arr,start,mid,end):
    temp=[]
    left=start
    center=mid
    right=end
    while left<mid and center<end:
        if arr[left]<=arr[center]:
            temp.append(arr[left])
            left+=1
        else:
            temp.append(arr[center])
            center += 1
    while left<mid:
        temp.append(arr[left])
        left += 1
    while center<end:
        temp.append(arr[center])
        center += 1
    c=0
    for i in range(start,end):
        arr[i]=temp[c]
        c=c+1



def mergeSort(arr,start,end):

    if start==end-1:
        return [arr[start]]
    else:
        mid=int((start+end)/2)
        left=mergeSort(arr,start,mid)
        right=mergeSort(arr,mid,end)
        return merge(arr,start,mid,end)



mergeSort(arr,0,len(arr))
print(arr)