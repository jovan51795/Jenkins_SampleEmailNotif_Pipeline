pipeline {
    agent any
    tools {
        maven 'Apache Maven 3.8.6'
    }
    environment {
        PATH_TO_TRUSTSTORE = 'C:/Users/JCABATUAN/Desktop/certs'
        JAVA_OPTS = "-Djavax.net.ssl.trustStore=${PATH_TO_TRUSTSTORE}/cacerts -Djavax.net.ssl.trustStorePassword=changeit -Dhudson.tasks.MailSender.SEND_TO_UNKNOWN_USERS=true -Dhudson.tasks.MailSender.SEND_TO_USERS_WITHOUT_READ=true"
    }
    stages {
        stage('Checkout') {
            steps {
                script {
                    checkout scm
                }
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
    post {
        always {
            emailext (
                body: 'A Test EMail',
                recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                subject: 'Test',
                to: 'jovscb@gmail.com'
            )
        }
    }
}
