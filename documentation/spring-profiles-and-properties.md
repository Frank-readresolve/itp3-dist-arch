# Spring Profiles and Properties

## What is a Spring Profile?

Spring Profile map **beans** \* to different profiles (dev, test, prod for example).

- Beans are objects that are instanciated, assembled and handled by Spring IoC Containers (IoC stands for Inversion of Control). When these objects are created, Spring injects the beans in order to create the dependences between each other.

### To use Spring Profiles

Use **@Profile** annotation.

Examples:

@Profile("dev") => the bean will only be instanciated with the dev profile.
@Profile("!dev") => the bean will be instanciated with all profiles except dev.

## Is there a default profile?

Yes.

Any bean that does not specify a profile belongs to the default profile.

Spring also provides a way to set the default profile when no other profile is active — by using the spring.profiles.default property.

Therefore we can define a default profile by ourselves.

## How to specify a profile when running an app from command line?

In the case we want to use the dev profile, specify on the command line using the switch `--spring.profiles.active=dev` ([source](https://docs.spring.io/spring-boot/docs/1.2.0.M1/reference/html/boot-features-profiles.html#boot-features-profiles))

## How to specify a profile when running from IDE? Run configurations

In Eclipse, right click on your project.

- Select "run as..."
- "Run configuration"
- In the "Spring profile" part of this window, select the desired profile in "Profile".

## Can we "mix" profiles, e.g. default + production?

Yes

## Can we have multiple properties files?

Yes. For instance we can have a properties file for the dev environment and for the prod environment.

## Can we use variables in properties files?
