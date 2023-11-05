pipeline {
    agent any
    tools {
    maven 'Apache Maven 3.8.6'
    }
    environment {
            PATH_TO_TRUSTSTORE = 'C:/Users/JCABATUAN/Desktop/certs'
        }
    stages {
//         stage('Add certificate') {
//             steps {
//                 script {
//                     withEnv(['JAVA_OPTS=-Djavax.net.ssl.trustStore=$PATH_TO_TRUSTSTORE/cacerts -Djavax.net.ssl.trustStorePassword=changeit']) {
//
//                     }
//                 }
//             }
//         }
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
            script {
                withEnv([
                'JAVA_OPTS=-Djavax.net.ssl.trustStore=$PATH_TO_TRUSTSTORE/cacerts -Djavax.net.ssl.trustStorePassword=changeit',
                'JAVA_OPTS=-Dhudson.tasks.MailSender.SEND_TO_UNKNOWN_USERS=true',
                'JAVA_OPTS=-Dhudson.tasks.MailSender.SEND_TO_USERS_WITHOUT_READ=true'
                ]) {
                    emailext (
                        body: 'A Test EMail',
                        recipientProviders: [[$class: 'CulpritRecipientProvider'], [$class: 'RequesterRecipientProvider']], //,
                        subject: 'Test',
                        to: 'jovscb@gmail.com'
                    )
                }
            }
        }
    }
//     post {
//         always {
//             emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
//         }
//     }
}