package br.com.nk.vr.model;

public enum Transacao {
	SALDO_INSUFICIENTE {
		@Override
		public boolean executaTransacao(Cartao cartao, String valor) {
			return false;
		}
	}, SENHA_INVALIDA {
		@Override
		public boolean executaTransacao(Cartao cartao, String valor) {
			return !cartao.getSenha().equals(valor);
		}
	}, CARTAO_INEXISTENTE {
		@Override
		public boolean executaTransacao(Cartao cartao, String valor) {
			// TODO Auto-generated method stub
			return false;
		}
	};
	
	public abstract boolean executaTransacao(Cartao cartao, String valor);

}
