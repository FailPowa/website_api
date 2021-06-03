# website_api

## Requirements

- **Open JDK 11**
```
apt install openjdk-11-jdk
java --version
```

- **Maven**
```
apt install maven
mvn -version
```

- **MySQL**
```
apt install mysql-server
```

## Project setup
```sql
# Setup the database
sudo mysql
mysql> CREATE DATABASE api_database;
mysql> CREATE USER 'api_user_name'@'localhost' IDENTIFIED BY 'api_user_password';
mysql> GRANT ALL PRIVILEGES ON api_database.* TO 'api_user_name'@'localhost';
mysql> FLUSH PRIVILEGES;
mysql> \q

# Start the project
mvn spring-boot:run
```