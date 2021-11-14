狂神springboot简单入门的案例分析：
一.
需要解决的问题？
1· 导入静态资源
2· 首页
3· jsp，模板引擎Thymeleaf
4· 装配扩展SpringMvc
5· 增删改查
6· 拦截器
7· 国际化

二.
静态资源的访问路径：
1. webjars/**  ：是直接到classpath:/webjars/jquery/3.4.1/**路径下面去找  （注意这里是使用导入webjars包的形式将jquery包导入到项目
之中）   localhost:8080/webjars
2. /**   是classpath中去找（也就是下面的四个里面，默认是static）    localhost:8080/
3. classpath：/public（权限最小）    /static（默认）   /META-INF/resources    /resources(权限最大)

三.
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    if (!this.resourceProperties.isAddMappings()) {    //如果在配置文件自定义的静态资源的访问路径，那么默认的
    将全部失效   spring.mvc.static-path-pattern=/hello/,classpath:/kuang/
        logger.debug("Default resource handling disabled");
    } else {
        this.addResourceHandler(registry, "/webjars/**", "classpath:/META-INF/resources/webjars/");
        this.addResourceHandler(registry, this.mvcProperties.getStaticPathPattern(), (registration) -> {
            registration.addResourceLocations(this.resourceProperties.getStaticLocations());
            if (this.servletContext != null) {
                ServletContextResource resource = new ServletContextResource(this.servletContext, "/");
                registration.addResourceLocations(new Resource[]{resource});
            }
        });
    }
}
this.staticPathPattern = "/**";
CLASSPATH_RESOURCE_LOCATIONS = new String[]{"classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/"

---------------------------------------------------------------------------------
四.
首页index.html是放在静态资源的目录下面，可以直接在浏览器中进行访问，但是要是放在template目录下面的话，就不能直接访问，
必须使用controller控制器进行转换访问。  ---注意需要添加Thymeleaf模板引擎才可。 两个依赖


图标的话使用的是favicon.ico放在静态资源的目录下面（图片），然后在配置文件添加  spring.mvc.favicon。enabled=false 默认是true，源码
是默认没有使用图标的，这里改为false，表名我使用静态目录下的以favicon.ico命名的图片作为图标。   ---注意的是在最新的版本中已经没有了
图标（favicon这一功能）。

模板引擎：
结论：只要需要使用thymeleaf的话，只要添加thymeleaf依赖（两个），然后将html页面全部放在templates目录
下面即可（但是不能直接跳转，必须通过controller进行跳转）。
public static final String DEFAULT_PREFIX = "classpath:/templates/";
public static final String DEFAULT_SUFFIX = ".html";
上面是springboot源码对于视图的前后添加（类似视图解释器），加工完毕转发给templates中的对应的页面。
---------------------------------------------------------------------------------

五.
<html lang="en"  xmlns:th="http://www.thymeleaf.org">
需要在每一个页面中添加thymeleaf的命名空间，使得我们下面所有的thymeleaf代码都依据该规范进行。
<div th:text="${msg}">首页</div>   th:text="${msg}"  th:text 是接收文本内容然后覆盖页面中相应的数据
也就是说：所有的html元素都可以被thymeleaf替换接管：th:元素名！！！
===================================================================================================

六.  核心项目开始
1. 首页配置：
    1.注意点，所有页面的静态资源（超连接和图片）都需要使用thymeleaf接管（加上th：href）；
    2.@{/url}  /代表是根路径
    静态资源（图片，js）全部放在static下面  ；页面全部放在templates下面
    注意：在每个页面的上面加上thymeleaf的命名空间xmlns:th="http://www.thymeleaf.org"
2. 页面国际化：
    1.我么需要配置i18n文件
    2.我们如果需要在项目中进行按钮自动切换，我们需要自定义一个组件LocaleResolver
    3.记得将自己写的组件配置到spring容器 @Bean
    4.#{}
3. 登录 + 拦截器
4. 员工列表展示
    1.提取公共页面(一般是直接将公共的部分放到某个单独的页面上，为其他的页面进行抽取)
        1. th:frament="topbar"
        2. th:insert="~{commons/commons::topbar}"   th:replace="~{commonds/commonds::topbar}"(一般是replace直接替换)
        因为insert是在div里面再次嵌套一层，而replace是直接替换，没有嵌套！
        3. 如果要传递参数，可以直接使用（）传参，接收判断即可
    2. 列表循环展示   注意<button class="btn btn-sm btn-primary">编辑</button>
        注意： btn 代表按钮   btn-sm 小按钮   btn-primary 按钮颜色
5. 员工增修删操作  两部曲
    1.先创建controller进行操作的转移（thymeleaf中的templates里的页面是不能直接访问的，必须经过controller的处理）；
    2.跳转到相应页面处理完成后再次返回到controller，进行数据库的相应处理，最后重定位到list员工列表展示界面。
6. 添加404错误
    1.在resources根目录下面添加一个error文件夹，然后在里面创建404.html和500.html，
    2.会自动会error文件夹下面去找。