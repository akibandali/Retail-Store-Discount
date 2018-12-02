# Retail Store Discount Calulator
======================================

Build
-----
Use Maven:
```bash
mvn install
```

Testing
-------

To run the unit test:
```bash
mvn test
```

Running the Application
-------------------
Several options:
 1. Use the Maven Sprint Boot plugin: `mvn spring-boot:run`
 2. Build as above, then use `java -jar target/` like a normal Java microservice
 3. Run in Docker: `docker run -it illin5225.corp.amdocs.com:5000/authoring-command-service`
 4. Run in Kubernetes / Minikube - see [the template](cfg/kube/kubernetes.yaml.template) for starters.

    * For reference see the YAML file called "kubernetes-authoring-command-service.yaml" residing inside the tar.gz file uploaded to Nexus. (See the email for the location of the tar.gz file.)
    * Replace "value: !!!INSERT_ADDRESS_HERE!!! (an IP address or host name)" with "YOUR IP" as shown below
    * sed -i s/'value: !!!INSERT_ADDRESS_HERE!!! (an IP address or host name)'/'value: YOUR_IP'/g kubernetes-authoring-command-service.yaml
    * Example:
          sed -i s/'value: !!!INSERT_ADDRESS_HERE!!! (an IP address or host name)'/'value: 111.111.111.111'/g kubernetes-authoring-command-service.yaml
    * Replace the !!!ZOOKEEPER_PRODUCTION_HOST_INSERT_ADDRESS_HERE!!! (an IP address or host name) with your ZooKeeper production host
    * Replace the !!!KAFKA_PRODUCTION_HOST_INSERT_ADDRESS_HERE!!! (an IP address or host name) with your Kafka production host
    * Replace the A3S_URL value !!!INSERT_A3S_URL_HERE!!! with your A3S server
    * Replace A3S_USER and A3S_PASSWORD (!!!INSERT_A3S_USER_NAME_HERE!!!, !!!INSERT_A3S_PASSWORD_HERE!!!) with your user and password
    * If you want to use FAKE for the JWT validation type, put FAKE on the empty value of the SECURITY_JWT_TYPE variable
    * Replace A3S_KMS_TYPE and A3S_KMS_BASICS (!!!INSERT_A3S_KMS_TYPE_HERE!!!, !!!INSERT_A3S_KMS_BASICS_HERE!!!) with your KMS type
      (to set com.amdocs.msnext.kms.profiles.kms.kms-type) and KMS parameters basics (to set com.amdocs.msnext.kms.profiles.kms.parameters.basics)


Technical Information
---------------------

### Cucumber Tests

We use Cucumber for BDD tests in this project.

#### Running Cucumber tests
This can be done using a full Maven `install` lifecycle:
Steps:
```bash
maven install
```
Go to the local maven repository where Artifacts get installed
eg: C:\Users\<username>\.m2\repository\com\retail\store\retail-store\1.0.0-SNAPSHOT>
Copy below two files to this location from source code
runner.cmd
Bill.json
Now make the changes in "Bill.jso"n accordingly
Run "runner.cmd"
See the output on console.
