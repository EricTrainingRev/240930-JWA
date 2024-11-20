# Maven
Maven requires a little more configuration on our part: we have to get the configuration data for YUM first, update Yum's repository information with that configuration information, then we can install Maven
- connect to your instance
- install maven using yum
```bash
sudo yum install maven
```
- verify installation
```bash
mvn -version
```
- **NOTE**: check the jdk indicated by the Java command after this. If you want to use a different version of Java you will need to configure your instance
```bash
sudo update-alternatives --config java
```