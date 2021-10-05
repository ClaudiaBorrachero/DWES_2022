package daoproductline;

import java.util.List;

public interface ProductLineDAO {

	ProductLine getProductLine(String name);
	List<ProductLine> getProductLines();
	void deleteProductLine(String name);
}
