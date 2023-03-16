package projetofinal.com.br.banco.controller;
//package bancoitau.com.br.banco.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import bancoitau.com.br.banco.model.Conta;
//import bancoitau.com.br.banco.model.Movimentacao;
//
//@RestController
//@RequestMapping("/transferencia")
//public class TransferenciaController {
//
//    @Autowired
//    private MovimentacaoService movimentacaoService;
//
//    @Autowired
//    private ContaService contaService;
//
//    @PostMapping
//    public ResponseEntity<String> transferirValores(@RequestParam int contaOrigem,
//                                                     @RequestParam int contaDestino,
//                                                     @RequestParam double valor) {
//        if (contaOrigem == contaDestino) {
//            return ResponseEntity.badRequest().body("As contas de origem e destino não podem ser iguais.");
//        }
//
//        Conta contaOrigemObj = contaService.recuperarPeloNumero(contaOrigem);
//        if (contaOrigemObj == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        Conta contaDestinoObj = contaService.recuperarPeloNumero(contaDestino);
//        if (contaDestinoObj == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        if (contaOrigemObj.getSaldo() < valor) {
//            return ResponseEntity.badRequest().body("Saldo insuficiente na conta de origem.");
//        }
//
//        Movimentacao movimentacaoDebito = new Movimentacao();
//        movimentacaoDebito.setValor(-valor);
//        movimentacaoDebito.setTipoOperacao(2);
//        movimentacaoDebito.setDescricao("Transferência para conta " + contaDestino);
//        movimentacaoDebito.setNumeroConta(contaOrigemObj.getNumeroConta());
//
//        Movimentacao movimentacaoCredito = new Movimentacao();
//        movimentacaoCredito.setValor(valor);
//        movimentacaoCredito.setTipoOperacao(1);
//        movimentacaoCredito.setDescricao("Transferência da conta " + contaOrigem);
//        movimentacaoCredito.setNumeroConta(contaDestinoObj.getNumeroConta());
//
//        boolean resultado = movimentacaoService.realizarTransferencia(movimentacaoDebito, movimentacaoCredito);
//        if (resultado) {
//            return ResponseEntity.ok("Transferência realizada com sucesso.");
//        } else {
//            return ResponseEntity.badRequest().body("Erro ao realizar transferência.");
//        }
//    }
//}