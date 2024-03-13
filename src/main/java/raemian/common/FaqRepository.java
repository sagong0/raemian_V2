package raemian.common;

import java.util.List;

import raemian.admin.domain.Faq;

public interface FaqRepository {
	List<Faq> findAll();
}
