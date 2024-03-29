package com.adappsdev.wscursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adappsdev.wscursomc.domain.Categoria;
import com.adappsdev.wscursomc.domain.Cidade;
import com.adappsdev.wscursomc.domain.Cliente;
import com.adappsdev.wscursomc.domain.Endereco;
import com.adappsdev.wscursomc.domain.Estado;
import com.adappsdev.wscursomc.domain.ItemPedido;
import com.adappsdev.wscursomc.domain.Pagamento;
import com.adappsdev.wscursomc.domain.PagamentoComBoleto;
import com.adappsdev.wscursomc.domain.PagamentoComCartao;
import com.adappsdev.wscursomc.domain.Pedido;
import com.adappsdev.wscursomc.domain.Produto;
import com.adappsdev.wscursomc.domain.enums.EstadoPagamento;
import com.adappsdev.wscursomc.domain.enums.TipoCliente;
import com.adappsdev.wscursomc.repositories.CategoriaRepository;
import com.adappsdev.wscursomc.repositories.CidadeRepository;
import com.adappsdev.wscursomc.repositories.ClienteRepository;
import com.adappsdev.wscursomc.repositories.EnderecoRepository;
import com.adappsdev.wscursomc.repositories.EstadoRepository;
import com.adappsdev.wscursomc.repositories.ItemPedidoRepository;
import com.adappsdev.wscursomc.repositories.PagamentoRepository;
import com.adappsdev.wscursomc.repositories.PedidoRepository;
import com.adappsdev.wscursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class WsCursomcApplication implements CommandLineRunner{
		
	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private ProdutoRepository produtoRepository;	
	@Autowired 
	private CidadeRepository cidadeRepository;
	@Autowired 
	private EstadoRepository estadoRepository;
	@Autowired 
	private ClienteRepository clienteRepository;
	@Autowired 
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WsCursomcApplication.class, args);		 
	}

	@Override
	public void run(String... args) throws Exception {
				
		/*********************
		 * CATEGORIAS E PRODUTOS
		 * *******************/
		//Instanciando as categorias
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");


		
		//Instanciando os produtos
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		//Associando os produtos que pertencem a cada categoria
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		//Associando as categorias aos produtos
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		//Adicionando aos repositórios
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		/*********************
		 * ESTADOS E CIDADES
		 * *******************/
		//Instanciando os Estados
		Estado est1 = new Estado(null, "Acre");
		Estado est2 = new Estado(null, "Alagoas");
		Estado est3 = new Estado(null, "Amapá");
		Estado est4 = new Estado(null, "Amazonas");
		Estado est5 = new Estado(null, "Bahia");
		Estado est6 = new Estado(null, "Ceará");
		Estado est7 = new Estado(null, "Distrito Federal");
		Estado est8 = new Estado(null, "Espírito Santo");
		Estado est9 = new Estado(null, "Goiás");
		Estado est10 = new Estado(null, "Maranhão");
		Estado est11 = new Estado(null, "Mato Grosso");
		Estado est12 = new Estado(null, "Mato Grosso do Sul");
		Estado est13 = new Estado(null, "Minas Gerais");
		Estado est14 = new Estado(null, "Pará");
		Estado est15 = new Estado(null, "Paraíba");
		Estado est16 = new Estado(null, "Paraná");
		Estado est17 = new Estado(null, "Pernambuco");
		Estado est18 = new Estado(null, "Piauí");
		Estado est19 = new Estado(null, "Rio de Janeiro");
		Estado est20 = new Estado(null, "Rio Grande do Norte");
		Estado est21 = new Estado(null, "Rio Grande do Sul");
		Estado est22 = new Estado(null, "Rondônia");
		Estado est23 = new Estado(null, "Roraima");
		Estado est24 = new Estado(null, "Santa Catarina");
		Estado est25 = new Estado(null, "São Paulo");
		Estado est26 = new Estado(null, "Sergipe");
		Estado est27 = new Estado(null, "Tocantins");
		
		//String nomesEstados[]={"Acre","Alagoas","Amapá","Amazonas","Bahia","Ceará","Distrito Federal","Espírito Santo","Goiás","Maranhão","Mato Grosso","Mato Grosso do Sul","Minas Gerais","Pará","Paraíba","Paraná","Pernambuco","Piauí","Rio de Janeiro","Rio Grande do Norte","Rio Grande do Sul","Rondônia","Roraima","Santa Catarina","São Paulo","Sergipe","Tocantins"};
		//String siglasEstados[]={"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};

		//Instanciando as cidades
		Cidade c1 = new Cidade(null, "Uberlandia", est13);
		Cidade c2 = new Cidade(null, "São Paulo", est25);
		Cidade c3 = new Cidade(null, "Campinas", est25);

		//Associando os estados com as cidades
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		//Adicionando aos repositórios
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4, est5, est6, est7, est8, est9, 
				est10, est11, est12, est13, est14, est15, est16, est17, est18, est19, est20, est21, 
				est22, est23, est24, est25, est26, est27));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		//Instanciando Clientes, endereços e telefones
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@email.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
				
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		//Instanciando pedidos e forma de pagamento 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO , ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE , ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		//Instanciando ítens de pedido
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));		
	}	
}