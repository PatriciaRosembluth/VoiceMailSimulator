public interface ConnectionState {
	public void dial(String key, Connection connection);
	public int getState(); 
}
