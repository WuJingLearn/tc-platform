

## 一.在nacos 创建一个数据项，排行榜的配置
group: platform
dataId: 自定义场景

在nacos创建一个排行榜配置，排行榜周期支持日榜,周榜,自定义时长, 
period可以设置为day,week,custom，分别为日榜,周榜,自定义时长,每隔新的周期都是一个新的榜单。
start,end开始结束时间在自定义时长榜单时生效。
bucket用来配置排行榜分桶数量,用于缓解在高并发写排行榜时的热点问题。
limit 用来限制排行榜可上榜数量

``` json
{
    "scene":"programmingLanguage", 
    "period":"week",
    "start":"2023-11-01 00:00:00",
    "end":"2023-11-30 23:59:59",
    "bucket":2,
    "limit":5
}

```


## 入榜操作
http://localhost:8080/leaderboard/enter post 
``` json
{
    scene:"programmingLanguage",
    "ruleItem","java",
    "score":"1" //每次加入的分数
}
```

## 查询
http://localhost:8080/leaderboard/get get
查询排榜
