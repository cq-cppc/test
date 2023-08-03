#共病危险因素挖掘软件

##软件包结构

`com.edu.cqupt.bigdata.RiskFactorExcavation.entity`包：包含了整个项目的实体类

`com.edu.cqupt.bigdata.RiskFactorExcavation.commom`包：包含一些枚举类，这些枚举类通常表示`entity`的一些属性，比如数据表的类型有`mysql`和`hive`这两种，在此基础上每个枚举类都提供了一些附加功能如`com.edu.cqupt.bigdata.RiskFactorExcavation.commom.table.TableType`提供了鉴别的功能使用`public static TableType verify(String type) throws Exception;`方法可以根据字符串鉴定是否存在该种数据类型，并返回该类型的单例对象。

`com.edu.cqupt.bigdata.RiskFactorExcavation.config`包：整个项目的配置类都在里面

`com.edu.cqupt.bigdata.RiskFactorExcavation.controller`包：包含了项目里的所有`controller`，本次项目使用的`controller`是`TableController`、`AlgorithmController`、`FileController`以及`RuntimeBusController`

`com.edu.cqupt.bigdata.RiskFactorExcavation.dao`包：包含了所有与数据交互的`mapper`，该项目使用了Mybatis-Plus插件

`com.edu.cqupt.bigdata.RiskFactorExcavation.schedule`包：由于大数据平台崩溃，本次项目未使用到该软件包

`com.edu.cqupt.bigdata.RiskFactorExcavation.service`包：包含了项目所有的`service`以及`service`对外展示以及接收的`entity`的一些视图，这些视图放在该包下的`request`和`response`包中。为了方便编码测试，项目里面在`service`的接口跟其实现类里加了一层适配器所有接口的适配器均放在该包下的`adapter`包中

`com.edu.cqupt.bigdata.RiskFactorExcavation.util`包：一些工具类，本次仅使用了`NameNameGenerator`和`PythonRun`两个类

注：项目中只对`service`编写注解，未写注释的方法不需要写入设计说明中


