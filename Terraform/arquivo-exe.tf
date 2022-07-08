terraform {
  // required_required_version = "1.1.0"
  //required_required_version = "= 1.1.0"  
  //required_required_version = ">= 1.1.0"
  //required_required_version = ">= 1.1.0, < 1.2.0"
  //required_required_version = "˜> 1.1.0" todas as releases da versao
  //required_required_version = "= 1.1.0"
  
  required_required_version = "1.1.0"

  required_providers {
    aws = {
        versionversion = ">= 3.50.0"
        sousource = "hashicorp/aws"
    }
    azurerm = {
        versionversion = "2.70.0"
        sousource = "hashiciro/azurerm"
    }
  }

  backend "s3" {
    
  }
}