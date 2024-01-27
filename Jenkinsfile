@Library('my-shared-library') _
pipeline{
    agent any

    parameters {
  choice choices: ['create', 'destroy'], description: 'Choose create or destroy', name: 'action'
  string(name: 'aws_account_id', description: " AWS Account ID", defaultValue: '381492133360')
  string(name: 'Region', description: "Region of ECR", defaultValue: 'us-east-1')
  string(name: 'ECR_REPO_NAME', description: "name of the ECR", defaultValue: 'new-repo')
}
    environment{

        ACCESS_KEY = credentials('AWS_ACCESS_KEY_ID')
        SECRET_KEY = credentials('AWS_SECRET_KEY_ID')
    }


    stages {

        
        stage('git Checkout'){
            when { expression { params.action == 'create' } }
            steps{
                script{
                    gitCheckout(
                        branch: "master",
                        url: "https://github.com/basuadrija/Jenkins.git"
                    )
                }
           
            }
        }
        

        stage('Unit Test Maven'){
            when { expression { params.action == 'create' } }
            steps{
                script{
                    mvnTest()
                }
            }
        }

        stage('Integration Test Maven'){
            when { expression { params.action == 'create' } }
            steps{
                script{
                    mvnIntegrationTest()
                }
            }
        }

        stage('Static Code Analysis'){
            when { expression { params.action == 'create' } }
            steps{
                script{
                    def SonarQubecredentialsId = 'sonarwithjenkins'
                    staticCodeAnalysis(SonarQubecredentialsId)
                }
            }
        }

        stage('Quality Gate Status Check'){
            when { expression { params.action == 'create' } }
            steps{
                script{
                    def SonarQubecredentialsId = 'sonarwithjenkins'
                    qualityGateStatus(SonarQubecredentialsId)
                }
            }
        }

        stage('Build with  Maven'){
            when { expression { params.action == 'create' } }
            steps{
                script{
                    mvnBuild()
                }
            }
        }

        stage('Build Image with  Docker'){
            when { expression { params.action == 'create' } }
            steps{
                script{
                    dockerBuild("${params.aws_account_id}","${params.Region}","${params.ECR_REPO_NAME}")
                }
            }
        }

        stage('Image Push ECR'){
            when { expression { params.action == 'create' } }
            steps{
                script{
                    sh """
                    aws configure set aws_access_key_id "$ACCESS_KEY"
                    aws configure set aws_secret_access_key "$SECRET_KEY"
                    aws configure set region "${params.Region}"
                    aws ecr get-login-password --region ${params.Region} | docker login --username AWS --password-stdin ${params.aws_account_id}.dkr.ecr.${params.Region}.amazonaws.com
                    docker push ${params.aws_account_id}.dkr.ecr.${params.Region}.amazonaws.com/${params.ECR_REPO_NAME}:latest
                    """
                }
            }
        }
    }

        post{
            success{
                    mail bcc: '', body: '''Hello 

                    The job is successful please check

                    Thanks
                    Adrija''', cc: '', from: '', replyTo: '', subject: 'Jenkins', to: 'adrija.tina93@gmail.com'

        }
    }
    
}
