package selenium_cherkasov.model;

public class Application {

	private String id;
	private String title;
	private String description;
	private String category;
	private String image;
	private String icon;

	public String getId() {
		return id;
	}
	public Application setId(String id) {
		this.id = id;
		return this;
	}

	public String getTitle() {
		return title;
	}
	public Application setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public Application setDescription(String description) {
		this.description = description;
		return this;
	}
	public String getCategory() {
		return category;
	}
	public Application setCategory(String category) {
		this.category = category;
		return this;
	}
	public String getImage() {
		return image;
	}
	public Application setImage(String image) {
		this.image = image;
		return this;
	}
	public String getIcon() {
		return icon;
	}
	public Application setIcon(String icon) {
		this.icon = icon;
		return this;
	}

}
