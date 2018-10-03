# Automation
Steps to run this test framework:
1. Install Ubuntu(I use 16.04)
   please refer to https://tutorials.ubuntu.com/tutorial/tutorial-install-ubuntu-desktop

2. Install Java
   sudo apt-get update
   sudo apt-get install default-jre
   sudo apt-get install default-jdk

3. Install Maven
   sudo apt-get install maven

4. Install Git
   sudo apt-get install git-core

5. Configure your own git setting
   git config --global user.name "testuser"
   git config --global user.email "testuser@example.com"

6. Clone this project
   git clone git@github.com:mikeywan/Automation.git

7. Enter into root folder(with pom.xml and testng.xml in it) of this project then run following command
   mvn clean test 

