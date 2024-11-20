# Git
Git is a relatively easy software to download and start using in Linux: most package management software will be able to download the Git software from the default package repository it has access to
- connect to your EC2 instance
- update Yum (not always needed, but good practice)
```bash
sudo yum update
```
- install git
```bash
sudo yum install git
```
- verify Git is ready to use
```bash
git --version
```
- assuming it is ready, add your username and email as basic configuration data
```bash
git config --global user.name "Your Name"
git config --global user.email "your-email@example.com"
```
This setup will allow you to start pulling content from Github, but if you want to push content to a remote repo you will need to provide a username and password token or an SSH key. I don't recommend setting this up, pulling content should be more than sufficient to experiment with the cloud and DevOps.