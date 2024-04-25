package CursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para verificar palabras palindromos
 */
@RestController
public class PalindromoController {

    /**
     * Endpoint de verificacion de polindromos
     * @param palindromo -> palabra a verificar
     * @return -> si es un palindromo o no
     */
    @GetMapping(value = "/verificar-palindromo/{palindromo}")
    public String determinarPalindromo(@PathVariable String palindromo){
        if(escanerPalindromo(palindromo)){
            return "La palabra "+palindromo+" ES un palindromo!";
        }
        return "La palabra "+palindromo+" NO es un palindromo!";
    }

    /**
     * Método para verificar si la palabra es un palindromo
     * @param palindromo -> Palabra a verificar
     * @return -> false si No es palindromo, true Si es palindromo
     */
    private boolean escanerPalindromo(String palindromo){
        int largo = palindromo.length();
        for(int i=0; i<largo/2; i++){
            if(palindromo.charAt(i) != palindromo.charAt(largo -i -1)){
                return false;
            }
        }
        return true;
    }

}
