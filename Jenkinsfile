@Library('my-shared-library') _
pipeline{
    agent any

    parameters {
  choice choices: ['create', 'destroy'], description: 'Choose create or destroy', name: 'action'
}

    stages {

        when { expression { param.action == 'create' } }
        stage('git Checkout'){
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
            when { expression { param.action == 'create' } }
            steps{
                script{
                    mvnTest()
                }
            }
        }

        stage('Integration Test Maven'){
            when { expression { param.action == 'create' } }
            steps{
                script{
                    mvnIntegrationTest()
                }
            }
        }

        stage('Static Code Analysis'){
            when { expression { param.action == 'create' } }
            steps{
                script{
                    staticCodeAnalysis()
                }
            }
        }

        }
    }
