package com.produtopostgres.cadprodutopostgres.resources;

import com.produtopostgres.cadprodutopostgres.domain.Produto;
import com.produtopostgres.cadprodutopostgres.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    @ApiOperation(value="Retorna uma lista de produtos")
    public List<Produto> listaprodutos(){return produtoRepository.findAll();}

    @GetMapping("/produto/{id}")
    @ApiOperation(value="Retorna um produto")
    public Produto listaprodutosunico(@PathVariable(value = "id")long id){return produtoRepository.findById(id);}

    @PostMapping("/produto")
    @ApiOperation(value="Cria um produto")
    public Produto createproduto (@RequestBody Produto produto){return produtoRepository.save(produto);}

    @DeleteMapping("/produto")
    @ApiOperation(value="Deleta um produto")
    public void deleteproduto (@RequestBody Produto produto){ produtoRepository.delete(produto);}

    @PutMapping("/produtos")
    @ApiOperation(value="Atualiza um produto")
    public void atualizaproduto (@RequestBody Produto produto){produtoRepository.save(produto);}
}
