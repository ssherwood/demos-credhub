# SpringBoot CredHub Demo

## Overview

When run within CloudFoundry and bound to the CredHub Service Broker any established
secrets will be presented to the container in a modified VCAP_SERVICES JSON.

This mapping is handled by CloudFoundry transparently to the application, so no other
special libraries/tools are needed (just the ability to parse VCAP_SERVICES).

SpringBoot automatically parses the VCAP_SERVICES and adds the results to the
Environment (and can therefore be used in standard SPEL expressions and configuration
properties).

## Usage

### Build

```
./gradlew clean build
```

### Deploy

```bash
$ cf push demo-credhub -p build/libs/cf-credhub-0.0.1-SNAPSHOT.jar
$ curl http://demo-credhub.<your-domain>/secrets
```
^ you should see the defaults "unknown#"

### Bind CredHub

```bash
$ cf create-service credhub default my-secrets -c '{"secret-list":"foo,bar,baz"}'
$ cf restage demo-credhub
```
^ you should see the "foo,bar,baz" secrets

## Other Resources
 
* [Blog: Learn How the CredHub Service Broker Applies the Principle of Least Privilege](https://content.pivotal.io/blog/enterprise-architects-its-time-to-learn-how-the-credhub-service-broker-applies-the-principle-of-least-privilege-to-your-secrets)
* https://credhub-api.cfapps.io