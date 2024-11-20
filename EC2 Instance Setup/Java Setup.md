# Java
Java (should be) an easy download for your instance
- connect to your instance
- update Yum
```bash
sudo yum update
```
- download the specific version of Java you want (using jdk11 here)
```bash
sudo yum install java-11-amazon-corretto
```
- check the version is correct
```bash
java --version
```