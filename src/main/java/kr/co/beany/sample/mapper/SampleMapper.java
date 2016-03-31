package kr.co.beany.sample.mapper;
 
import java.util.List;
 
import kr.co.beany.sample.vo.SampleVo;
 
import org.springframework.stereotype.Repository;
 
@Repository(value = "sampleMapper")
public interface SampleMapper {
	
	
	
    List<SampleVo> getAll();
 
    SampleVo get(int sampleNo);
 
    void add(SampleVo sampleVo);
 
    void update(SampleVo sampleVo);
 
    void delete(int sampleVo);
    
    List<SampleVo> restAll();
}