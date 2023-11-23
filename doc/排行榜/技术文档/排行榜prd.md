

# 排行榜
建设一个可配置,可扩展的排行榜系统,只需要少量的二次开发,就可以构造一个排行榜系统




## 请求参数
Controller的请求参数定义在client层。adapter模版用来接收外部请求，对外提供http和rpc接口。
rpc接口的信息一定是定义在client层的。http接口倒是不需要定义在client层， 可以直接定义在application层。
但是为了统一，我们直接全部定义在client层即可。
