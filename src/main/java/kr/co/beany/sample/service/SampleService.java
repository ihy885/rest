package kr.co.beany.sample.service;
 
import java.util.List;
 
import javax.annotation.Resource;
 
import kr.co.beany.sample.mapper.SampleMapper;
import kr.co.beany.sample.vo.SampleVo;


import org.springframework.stereotype.Service;
 
@Service(value = "sampleService")
public class SampleService implements SampleMapper {

    @Resource(name = "sampleMapper")
    private SampleMapper sampleMapper;
 
    public List<SampleVo> getAll() {
        return this.sampleMapper.getAll();
    }
 
    public SampleVo get(int sampleNo) {
        return this.sampleMapper.get(sampleNo);
    }
 
    public void add(SampleVo sampleVo) {
        this.sampleMapper.add(sampleVo);
    }
 
    public void update(SampleVo sampleVo) {
        this.sampleMapper.update(sampleVo);
    }
 
    public void delete(int sampleNo) {
        this.sampleMapper.delete(sampleNo);
    }

    List<SampleVo> sampleVos;
    
	public List<SampleVo> restAll() {
		// TODO Auto-generated method stub
		return sampleVos;
	}
    
    
    
    
   
}