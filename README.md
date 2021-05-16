# Prueba-ML

Para ejecutar la API REST:
URL: https://dnlaz72w76.execute-api.us-east-2.amazonaws.com/mutant
Ejemplo de request:
{
  "dna": [
    "ATGCGA",
    "CAGTGC",
    "TTATGT",
    "AGAAGG",
    "CCCCTA",
    "TCACTG"
  ]
}

Para poder esperar una respuesta exitosa, los carácteres ingresados no deben ser diferentes a (A, T, G, C). De igual forma, se espera una entrada como matriz N x N.
