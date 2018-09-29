//
//  main.cpp
//  AlgorithmTraining
//
//  Created by 유태우 on 18/09/2018.
//  Copyright © 2018 유태우. All rights reserved.
//
#include<stdio.h>
struct process
{
    int burst,wait,no;
}p[20]={0,0};

int main()
{
    int n,i,j,totalwait=0,totalturn=0;
    printf("\nEnter The No Of Process :");
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        printf("Enter The Burst Time (in ms) For Process #%2d :",i+1);
        scanf("%d",&p[i].burst);
        p[i].no=i+1;
    }
    
    for(i=0;i<n;i++)
        for(j=0;j<n-i-1;j++)
            if(p[j].burst>p[j+1].burst)
            {
                p[j].burst^=p[j+1].burst^=p[j].burst^=p[j+1].burst;
                p[j].no^=p[j+1].no^=p[j].no^=p[j+1].no;
            }
    
    printf("\nProcess \t Waiting Time TurnAround Time ");
    for(i=0;i<n;i++)
    {
        printf("\nProcess # %-12d%-15d%-15d",p[i].no,p[i].wait,p[i].wait+p[i].burst);
        p[i+1].wait=p[i].wait+p[i].burst;
        totalwait=totalwait+p[i].wait;
        totalturn=totalturn+p[i].wait+p[i].burst;
    }
    printf("\n\nAverage\n---------");
    printf("\nWaiting Time : %f ms",totalwait/(float)n);
    printf("\nTurnAround Time : %f ms\n\n",totalturn/(float)n);
    return 0;
    
}
