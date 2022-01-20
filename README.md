# ifelse

#### 介绍

代码中如果if-else或者case-switch比较多,
阅读起来比较困难,
维护起来也比较困难。
如何解决呢？利用策略模式让你的代码更优雅。

#### 使用说明

**场景**：根据订单的类型做不同的业务逻辑处理,如打折。

---

**实现原理**：利用注解，将业务拆分为接口，每种电子产品类型实现该接口（只关注本类型的业务），在实现类上加上自定义注解表明是哪种电子产品类型，在写一个策略类实现该接口，该策略类根据类型的不同去调用不同的实现类即可。
    外层调用者只需调用接口即可。

---

**接口:** ElectronicProductService，如方法discount（打折）

---

**业务实现**：ComputerServiceImpl（电脑产品），MobilePhoneServiceImpl（手机产品），TVServiceImpl（电视产品）。

**业务要点**：每个业务实现类只需加上@ElectronicType(ElectronicEnum.TV)电子产品类型注解即可

---

**注解**：ElectronicType 电子产品类型注解 

---

**枚举**：ElectronicEnum 电子产品类型
