//var.location    <<-- como usa no code
variable "location" {
    description = "variavel de localização"
    type = string
    default = "West Europe"
    sensitive = true // ñ mostra o valor
}


// linha de comnado
// export TF_VAR_location="Brazil south"
// terraform plan -var="location=Brazil South"