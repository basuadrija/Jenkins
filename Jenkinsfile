pipeline{
    agent any
    stages {
        stage('git Checkout'){
            steps{
                script{
                    gitCheckout(
                        branch: "master"
                        url: "https://github.com/basuadrija/Jenkins.git"
                    )
                }
            }
        

        stage('Unit Test Maven'){
            steps{
                script{
                    mvnTest()
                }
            }
        }

<<<<<<< HEAD
        stage('Integration Test Maven'){
            steps{
                script{
                    mvnIntegrationTest()
                }
            }
        }

        }
    }
=======
    }
}
    
>>>>>>> 4940cad4fadd85402be622e875dc278ce49998f7
