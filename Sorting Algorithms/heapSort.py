arr=[2,42,13,67,34,255,7,-2,-2,1,13,55]

#not done yet!!!!!!!!!!!!!!

def heapify(arr,i,len):
    right_exist = False
    if 2*i+1<len:
        left=2*i+1
        if 2*i+2<len:
            right=2*i+2
            right_exist=True


        if arr[left]>arr[i]:
            max=left
            if(right_exist):
                if arr[right]>arr[left]:
                    max=right

            arr[i],arr[max]=arr[max],arr[left]
            heapify(arr,max,len)

        elif (right_exist):
            if arr[right]>arr[i]:
                arr[i], arr[right] = arr[right], arr[i]
                max = right
                heapify(arr, max, len)
    # print(arr)

def buildHeap(arr):
    for i in range(int(len(arr)/2)-1,-1,-1):
        heapify(arr,i,len(arr))

    print(arr)

def heapSort(arr):
    buildHeap(arr)
    lent=len(arr)
    while lent>0:
        arr[0],arr[lent-1]=arr[lent-1],arr[0]
        lent=lent-1
        heapify(arr,0,lent)


heapSort(arr)

print(arr)



