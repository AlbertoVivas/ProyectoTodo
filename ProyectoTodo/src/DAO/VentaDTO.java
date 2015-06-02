package modelo.persistencia.DTO;

public class VentaDTO extends GenericDTO {

		public int idVenta;
		public String idTicket;
		public float importe;
		public String articulo;
		private float pvreal;
		private String stock;
		
		public int getIdVenta() {
			return idVenta;
		}
		public void setIdVenta(int idVenta) {
			this.idVenta = idVenta;
		}
		public String getIdTicket() {
			return idTicket;
		}
		public void setIdTicket(String idTicket) {
			this.idTicket = idTicket;
		}
		public float getImporte() {
			return importe;
		}
		public void setImporte(float importe) {
			this.importe = importe;
		}
		public String getArticulo() {
			return articulo;
		}
		public void setArticulo(String articulo) {
			this.articulo = articulo;
		}
		
		public VentaDTO(String idTicket, String articulo, String stock, float pvreal) {
			
			this.idTicket = idTicket;
			this.pvreal = pvreal;
			this.articulo = articulo;
			this.stock = stock;
		}
		
		public VentaDTO(int idventa) {
			
			this.idVenta = idventa;
		}
		
		public float getPvreal() {
			return pvreal;
		}
		public void setPvreal(float pvreal) {
			this.pvreal = pvreal;
		}
		public String getStock() {
			return stock;
		}
		public void setStock(String stock) {
			this.stock = stock;
		}
		
		
}
