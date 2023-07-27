# Spring Profiles and Properties

## What is a Spring Profile?

Spring Profile map **beans** \* to different profiles (dev, test, prod for example).

- Beans are objects that are instanciated, assembled and handled by Spring IoC Containers (IoC stands for Inversion of Control). When these objects are created, Spring injects the beans in order to create the dependences between each other.

- ([source](<[https://docs.spring.io/spring-boot/docs/1.2.0.M1/reference/html/boot-features-profiles.html#boot-features-profiles](https://www.baeldung.com/spring-profiles)>))

### To use Spring Profiles

Use **@Profile** annotation.

Examples:

@Profile("dev") => the bean will only be instanciated with the dev profile.
@Profile("!dev") => the bean will be instanciated with all profiles except dev.

([source](https://www.baeldung.com/spring-profiles))

## Is there a default profile?

Yes.

Any bean that does not specify a profile belongs to the default profile.

Spring also provides a way to set the default profile when no other profile is active — by using the spring.profiles.default property.

Therefore we can define a default profile by ourselves.

([source](https://www.baeldung.com/spring-profiles))

## How to specify a profile when running an app from command line?

In the case we want to use the dev profile, specify on the command line using the switch `--spring.profiles.active=dev`

([source](https://docs.spring.io/spring-boot/docs/1.2.0.M1/reference/html/boot-features-profiles.html#boot-features-profiles))

## How to specify a profile when running from IDE? Run configurations

In Eclipse, right click on your project.

- Select "run as..."
- "Run configuration"

![Run configuration](./images/spring-profiles-01.png)

- In the "Spring profile" part of this window, select the desired profile in "Profile".

- ![Run configuration](./images/spring-profiles-02.png)

## Can we "mix" profiles, e.g. default + production?

## Can we have multiple properties files?

Yes. For instance we can have a properties file for the dev environment and for the prod environment.

## Can we use variables in properties files?

You can use variables in your application.properties file.
For example, you can to add custom properties to JWT token in your file properties, containing :

![image](https://github.com/Frank-readresolve/itp3-dist-arch/assets/94375151/f5c0b6be-6a0b-4bee-a2b2-a21954008287)
