package  one.digitalinnovation.beerstock.controller ;

import  io.swagger.annotations.Api ;
import  io.swagger.annotations.ApiOperation ;
import  io.swagger.annotations.ApiResponse ;
import  io.swagger.annotations.ApiResponses ;
import  one.digitalinnovation.beerstock.dto.BeerDTO ;
import  one.digitalinnovation.beerstock.dto.QuantityDTO ;
import  one.digitalinnovation.beerstock.exception.BeerAlreadyRegisteredException ;
import  one.digitalinnovation.beerstock.exception.BeerNotFoundException ;
import  one.digitalinnovation.beerstock.exception.BeerStockExceededException ;
import  org.springframework.web.bind.annotation.PathVariable ;
import  org.springframework.web.bind.annotation.RequestBody ;

import  javax.validation.Valid ;
import  java.util.List ;

@Api ( " Gerencia estoque de cerveja " )
public  interface  BeerControllerDocs {

    @ApiOperation ( value  =  " Operação de criação de cerveja " )
    @ApiResponses ( value  = {
            @ApiResponse ( código  =  201 , mensagem  =  " Criação de cerveja com sucesso " ),
            @ApiResponse ( code  =  400 , message  =  " Campos obrigatórios ausentes ou valor de intervalo de campo incorreto. " )
    })
    BeerDTO  createBeer ( BeerDTO  beerDTO ) lança  BeerAlreadyRegisteredException ;

    @ApiOperation ( value  =  " Retorna cerveja encontrada por um determinado nome " )
    @ApiResponses ( value  = {
            @ApiResponse ( code  =  200 , message  =  " Cerveja de sucesso encontrada no sistema " ),
            @ApiResponse ( code  =  404 , message  =  " Cerveja com o nome fornecido não encontrada. " )
    })
    BeerDTO  findByName ( @PathVariable  String  name ) lança  BeerNotFoundException ;

    @ApiOperation ( value  =  " Retorna uma lista de todas as cervejas registradas no sistema " )
    @ApiResponses ( value  = {
            @ApiResponse ( code  =  200 , message  =  " Lista de todas as cervejas cadastradas no sistema " ),
    })
    Listar < BeerDTO >  listBeers ();

    @ApiOperation ( value  =  " Excluir uma cerveja encontrada por um determinado Id válido " )
    @ApiResponses ( value  = {
            @ApiResponse ( code  =  204 , message  =  " Cerveja de sucesso excluída do sistema " ),
            @ApiResponse ( code  =  404 , message  =  " Cerveja com o ID fornecido não encontrado. " )
    })
    void  deleteById ( @PathVariable  Long  id ) lança  BeerNotFoundException ;
}
