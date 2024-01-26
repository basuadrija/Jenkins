@Library('my-shared-library') _
pipeline{
    agent any

    parameters {
  choice choices: ['create', 'destroy'], description: 'Choose create or destroy', name: 'action'
  string(name: 'aws_account_id', description: " AWS Account ID", defaultValue: '381492133360')
  string(name: 'Region', description: "Region of ECR", defaultValue: 'us-east-1')
  string(name: 'ECR_REPO_NAME', description: "name of the ECR", defaultValue: 'new-repo')
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
                    dockerPush("${params.aws_account_id}","${params.Region}","${params.ECR_REPO_NAME}")
                }
            }
        }

        }
    }
