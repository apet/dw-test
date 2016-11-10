node {
    stage 'Checkout'
    git url: 'https://github.com/apet/dw-test'

    stage 'Build and run tests'
    def mvnHome = tool 'M3'
    sh "${mvnHome}/bin/mvn clean verify"
}