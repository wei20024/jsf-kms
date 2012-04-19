package creative.fire.no202.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "kms_knowledge", catalog = "kms", schema = "")
public class KmsKnowledge implements Serializable {
	private static final long serialVersionUID = 1L;
	@Transient
	private int articles;
	@Transient
	private int books;

	@Id
	@Basic(optional = false)
	@Column(name = "knowledgeId")
	private String knowledgeId;

	@Column(name = "description")
	private String description;

	@Column(name = "touchTime")
	@Temporal(TemporalType.DATE)
	private Date touchTime;

	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kmsKnowledge")
	private Collection<KmsArticle> kmsArticleCollection;

	// cannot simultaneously fetch multiple bags fetch = FetchType.EAGER

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kmsKnowledge")
	private Collection<KmsBook> kmsBookCollection;

	@JoinColumn(name = "userId", referencedColumnName = "userId")
	@ManyToOne(optional = false)
	private KmsUser kmsUser;

	public KmsKnowledge() {
	}

	public KmsKnowledge(String knowledgeId) {
		this.knowledgeId = knowledgeId;
	}

	public String getKnowledgeId() {
		return knowledgeId;
	}

	public void setKnowledgeId(String knowledgeId) {
		this.knowledgeId = knowledgeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTouchTime() {
		return touchTime;
	}

	public void setTouchTime(Date touchTime) {
		this.touchTime = touchTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<KmsArticle> getKmsArticleCollection() {
		return kmsArticleCollection;
	}

	public void setKmsArticleCollection(Collection<KmsArticle> kmsArticleCollection) {
		this.kmsArticleCollection = kmsArticleCollection;
	}

	public Collection<KmsBook> getKmsBookCollection() {
		return kmsBookCollection;
	}

	public void setArticles(int articles) {
		this.articles = articles;
	}

	public void setBooks(int books) {
		this.books = books;
	}

	public int getArticles() {
		return articles;
	}

	public int getBooks() {
		return books;
	}

	public void setKmsBookCollection(Collection<KmsBook> kmsBookCollection) {
		this.kmsBookCollection = kmsBookCollection;
	}

	public KmsUser getKmsUser() {
		return kmsUser;
	}

	public void setKmsUser(KmsUser kmsUser) {
		this.kmsUser = kmsUser;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (knowledgeId != null ? knowledgeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof KmsKnowledge)) {
			return false;
		}
		KmsKnowledge other = (KmsKnowledge) object;
		if ((this.knowledgeId == null && other.knowledgeId != null) || (this.knowledgeId != null && !this.knowledgeId.equals(other.knowledgeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "creative.fire.no202.entity.KmsKnowledge[knowledgeId=" + knowledgeId + "]";
	}

}