package com.kuang.controller;

/*import jdk.nashorn.internal.ir.RuntimeNode;*/
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kuang.dto.LoginDTO;
import com.kuang.entity.*;
import com.kuang.service.*;
import com.kuang.utils.Result;
import com.kuang.utils.TokenUtil;
import com.kuang.vo.TokenVO;
import net.sf.jsqlparser.expression.WithinGroupExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


//@RestController相当于是Response+ Controller，是直接将结果返回给浏览器，不能跳转页面（视图解释器无用）
//通过thymeleaf模板的渲染，访问svg请求，就会将请求转发到Templte目录下面的
@RestController
public class SvgController {
    //创建NodeMapper接口的实体类：使用自动注入的方法
    @Autowired
    MutilService mutilService;
    @Autowired
    FileSystemService fileSystemService;
    @Autowired
    DiskIOService diskIOService;
    @Autowired
    ProcessMemoryService processMemoryService;
    @Autowired
    ProcessCpuService processCpuService;
    @Autowired
    NodeMemoryService nodeMemoryService;
    @Autowired
    CpuService cpuService;
    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;
    @Autowired
    JianKongService jianKongService;
    @Autowired
    OceanUserService oceanUserService;
    @Autowired
    PatternService patternService;
    @Autowired
    SoftwareService softwareService;
    @Autowired
    UserdataService userdataService;
    @Autowired
    NodeService nodeService;

    Integer i = -1;

    @RequestMapping(value = "/svg", method = RequestMethod.POST)
    public String doSvg(HttpServletRequest request, HttpServletResponse response, Model model) {
        String node = nodeService.getNode(i++);//每次查完上个，i自增1
        System.out.println(node);
        return node;
    }

    @RequestMapping(value = "/svg1", method = RequestMethod.POST)
    public String doSvg1() {
        String node = nodeService.getNode(i++);//每次查完上个，i自增1
        System.out.println(node);
        return node;
    }

    @RequestMapping(value = "/hello")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        return modelAndView;
    }
    @RequestMapping(value = "/pdf")
    public ModelAndView pdf() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pdf");
        return modelAndView;
    }
    @RequestMapping(value = "/table2-1")
    public ModelAndView table2_1(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("zxy_table2-1");
        return modelAndView;
    }
    @RequestMapping(value = "/table2-1/{time}")
    public ModelAndView table2_1delete(@PathVariable(value="time")String time,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        mutilService.Delete(time);
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("zxy_table2-1");
        return modelAndView;
    }
    @RequestMapping(value = "/deleteSelector")
    public ModelAndView table2_1deleteSelector(String[] item,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        for (String string : item) {
            mutilService.Delete(string);
        }
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("zxy_table2-1");
        return modelAndView;
    }
    @RequestMapping(value = "/table2-2")
    public ModelAndView table2_2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("zxy_table2-2");
        return modelAndView;
    }
    @RequestMapping(value = "/table2-pj")
    public ModelAndView table2_2_pj() {
        Mutil mutil = mutilService.findRecent();
        Mutil mutil2 = mutilService.complier(mutil);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("mutil",mutil);
        modelAndView.addObject("mutil2",mutil2);
        modelAndView.setViewName("table2-1-bottleneck");
        return modelAndView;
    }

    @RequestMapping(value = "/fvcom2")
    public ModelAndView index_test() {
        Mutil mutil = mutilService.findRecent();
        Mutil mutil2 = mutilService.complier(mutil);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("mutil",mutil);
        modelAndView.addObject("mutil2",mutil2);
        modelAndView.setViewName("index_test");
        return modelAndView;
    }

    @RequestMapping(value = "/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("node");
        return modelAndView;
    }
    @RequestMapping(value = "/test2/{id}")
    public ModelAndView test2(@PathVariable(value="id")String id) {
        accountService.Delete(id);
        List<Account> accountList = accountService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accountList",accountList);
        modelAndView.setViewName("show3");
        return modelAndView;
    }
    @RequestMapping(value = "/show")
    public ModelAndView show() {
        List<Account> accountList = accountService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accountList",accountList);
        modelAndView.setViewName("show");
        return modelAndView;
    }
    @RequestMapping(value = "/show2")
    public ModelAndView show2() {
        List<User> userList = userService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("show2");
        return modelAndView;
    }
    @RequestMapping(value = "/show3")
    public ModelAndView show3() {
        List<Account> accountList = accountService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accountList",accountList);
        modelAndView.setViewName("show3");
        return modelAndView;
    }
    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    public ModelAndView test2(User user) {
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.findAll();
        modelAndView.setViewName("show3");
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }

    @RequestMapping(value = "/zhibiaoinsert",produces = "text/html;charset=UTF-8")
    public ModelAndView zhibiaoinsert(Mutil mutil,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        mutilService.save2(mutil);
        PageHelper.startPage(pageNum, 10);
        List<Mutil> recent100 = mutilService.findRecent100();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100", recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("zxy_table2-1");
        return modelAndView;
    }

    @RequestMapping(value = "/delete")
    public ModelAndView delete(int id) {
        userService.delete(id);
        List<User> userList = userService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("show3");
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }

    @RequestMapping(value = "/table")
    public ModelAndView table() {
        List<Cpu> cpuList = cpuService.findAll();
        List<Cpu> cpuList_1 = cpuService.findAll_1();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cpuList",cpuList);
        modelAndView.addObject("cpuList_1",cpuList_1);
        modelAndView.setViewName("table");
        return modelAndView;
    }


    @RequestMapping(value = "/Page")
    public List<Cpu> getPage() throws Exception {
        // 调用业务逻辑,返回数据
        return cpuService.getList();
    }



    @RequestMapping("/getAllPage")
    public ModelAndView getAllPage(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,20);
        List<Cpu> cpuList = cpuService.getAllPage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cpuList",cpuList);
        PageInfo<Cpu> pageInfo = new PageInfo<Cpu>(cpuList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("table");
        return modelAndView;
    }
    @RequestMapping("/pj")
    public ModelAndView pj(){

        Mutil mutil = mutilService.findRecent();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("mutil",mutil);
        modelAndView.setViewName("pj");
        return modelAndView;
    }
    @RequestMapping("/111")
    public String helllo(){
        return "111";
    }

    @RequestMapping("/mon")
    public ModelAndView mon(){
        List<JianKong> jiankongList = jianKongService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jiankongList",jiankongList);
        modelAndView.setViewName("table2-1_monitoring");
        return modelAndView;
    }
    @RequestMapping("/mondelete/{id}")
    public ModelAndView mondelete(@PathVariable(value="id")String id){
        jianKongService.delete(id);
        List<JianKong> jiankongList = jianKongService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jiankongList",jiankongList);
        modelAndView.setViewName("table2-1_monitoring");
        return modelAndView;
    }
    @RequestMapping(value = "/tabletest")
    public ModelAndView tabletest(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("deletetest");
        return modelAndView;
    }
    @RequestMapping(value = "/deletetest")
    public ModelAndView table2_1deletetest(String[] item,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        for (String string : item) {
            mutilService.Delete(string);
        }
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("deletetest");
        return modelAndView;
    }
    @RequestMapping(value = "/login")
    public ModelAndView login() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Ocean_login");

        return modelAndView;
    }
    @RequestMapping(value = "/signup")
    public ModelAndView signup() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Ocean_signup");

        return modelAndView;
    }
    @RequestMapping(value = "/nnnnn")
    public String nnnnnn(LoginDTO loginDTO) {
        System.out.println(loginDTO.getUsername());
        System.out.println(loginDTO.getPassword());
        return "loginDTO";
    }

    @RequestMapping(value = "/table2-139")
    public ModelAndView table2_139(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100_139();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100_139",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("table_index_139");
        return modelAndView;
    }
    @RequestMapping(value = "/table2-139/{time}")
    public ModelAndView table2_139delete(@PathVariable(value="time")String time,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        mutilService.Delete_139(time);
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100_139();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100_139",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("table_index_139");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteSelector139")
    public ModelAndView table2_139deleteSelector(String[] item,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        System.out.println(item);
        for (String string : item) {
            mutilService.Delete_139(string);
            System.out.println(string);
        }
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100_139();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100_139",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("table_index_139");
        return modelAndView;
    }
    @RequestMapping(value = "/table139_add")
    public ModelAndView table139_add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("table_add_139");
        return modelAndView;
    }
    @RequestMapping(value = "/table_139_add",produces = "text/html;charset=UTF-8")
    public ModelAndView table139add(Mutil mutil,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        mutilService.save_139(mutil);
        PageHelper.startPage(pageNum, 10);
        List<Mutil> recent100_139 = mutilService.findRecent100_139();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100_139", recent100_139);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100_139);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("table_index_139");
        return modelAndView;
    }

    @RequestMapping(value = "/table2-149")
    public ModelAndView table2_149(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100_149();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100_149",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("table_index_149");
        return modelAndView;
    }
    @RequestMapping(value = "/table2-149/{time}")
    public ModelAndView table2_149delete(@PathVariable(value="time")String time,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        mutilService.Delete_149(time);
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100_149();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100_149",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("table_index_149");
        return modelAndView;
    }
    @RequestMapping(value = "/deleteSelector149")
    public ModelAndView table2_149deleteSelector(String[] item,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        for (String string : item) {
            mutilService.Delete_149(string);
        }
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100_149();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100_149",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("table_index_149");
        return modelAndView;
    }
    @RequestMapping(value = "/table149_add")
    public ModelAndView table149_add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("table_add_149");
        return modelAndView;
    }
    @RequestMapping(value = "/table_149_add",produces = "text/html;charset=UTF-8")
    public ModelAndView table149add(Mutil mutil,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        mutilService.save_149(mutil);
        PageHelper.startPage(pageNum, 10);
        List<Mutil> recent = mutilService.findRecent100_149();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent", recent);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("table_index_149");
        return modelAndView;
    }

    @RequestMapping(value = "/table2-150")
    public ModelAndView table2_150(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100_150();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100_150",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("table_index_150");
        return modelAndView;
    }
    @RequestMapping(value = "/table2-150/{time}")
    public ModelAndView table2_150delete(@PathVariable(value="time")String time,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        mutilService.Delete_150(time);
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100_150();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100_150",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("table_index_150");
        return modelAndView;
    }
    @RequestMapping(value = "/deleteSelector150")
    public ModelAndView table2_150deleteSelector(String[] item,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        for (String string : item) {
            mutilService.Delete_150(string);
        }
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100_150();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100_150",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("table_index_150");
        return modelAndView;
    }
    @RequestMapping(value = "/table150_add")
    public ModelAndView table150_add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("table_add_150");
        return modelAndView;
    }
    @RequestMapping(value = "/table_150_add",produces = "text/html;charset=UTF-8")
    public ModelAndView table150add(Mutil mutil,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        mutilService.save_150(mutil);
        PageHelper.startPage(pageNum, 10);
        List<Mutil> recent = mutilService.findRecent100_150();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent", recent);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("table_index_150");
        return modelAndView;
    }

    @RequestMapping(value = "/table2-152")
    public ModelAndView table2_152(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100_152();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100_152",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("table_index_152");
        return modelAndView;
    }
    @RequestMapping(value = "/table2-152/{time}")
    public ModelAndView table2_152delete(@PathVariable(value="time")String time,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        mutilService.Delete_152(time);
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100_152();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100_152",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("table_index_152");
        return modelAndView;
    }
    @RequestMapping(value = "/deleteSelector152")
    public ModelAndView table2_152deleteSelector(String[] item,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        for (String string : item) {
            mutilService.Delete_152(string);
        }
        PageHelper.startPage(pageNum,10);
        List<Mutil> recent100 = mutilService.findRecent100_152();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent100_152",recent100);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent100);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("table_index_152");
        return modelAndView;
    }
    @RequestMapping(value = "/table152_add")
    public ModelAndView table512_add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("table_add_152");
        return modelAndView;
    }
    @RequestMapping(value = "/table_152_add",produces = "text/html;charset=UTF-8")
    public ModelAndView table152add(Mutil mutil,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        mutilService.save_152(mutil);
        PageHelper.startPage(pageNum, 10);
        List<Mutil> recent = mutilService.findRecent100_152();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent", recent);
        PageInfo<Mutil> pageInfo = new PageInfo<Mutil>(recent);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("table_index_152");
        return modelAndView;
    }

    @RequestMapping(value = "/pattern")
    public ModelAndView pattern(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,12);
        List<Pattern> recent = patternService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent",recent);
        PageInfo<Pattern> pageInfo = new PageInfo<Pattern>(recent);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("pattern");
        return modelAndView;
    }
    @RequestMapping(value = "/pattern/{id}")
    public ModelAndView pattern_dele(@PathVariable(value="id")String id,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        patternService.delete(id);
        PageHelper.startPage(pageNum,10);
        List<Pattern> recent = patternService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent",recent);
        PageInfo<Pattern> pageInfo = new PageInfo<Pattern>(recent);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("pattern");
        return modelAndView;
    }
    @RequestMapping(value = "/pattern_dele")
    public ModelAndView pattern_deleSelector(String[] item,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        for (String string : item) {
            patternService.delete(string);
        }
        PageHelper.startPage(pageNum,10);
        List<Pattern> recent = patternService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent",recent);
        PageInfo<Pattern> pageInfo = new PageInfo<Pattern>(recent);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("pattern");
        return modelAndView;
    }
    @RequestMapping(value = "/pattern_add")
    public ModelAndView pattern_add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pattern_add");
        return modelAndView;
    }
    @RequestMapping(value = "/patterninsert",produces = "text/html;charset=UTF-8")
    public ModelAndView patterninsert(Pattern pattern,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        patternService.add(pattern);
        PageHelper.startPage(pageNum, 10);
        List<Pattern> recent = patternService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent", recent);
        PageInfo<Pattern> pageInfo = new PageInfo<Pattern>(recent);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("pattern");
        return modelAndView;
    }
    @RequestMapping(value = "/software")
    public ModelAndView soft(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,12);
        List<Software> recent = softwareService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent",recent);
        PageInfo<Software> pageInfo = new PageInfo<Software>(recent);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("software");
        return modelAndView;
    }
    @RequestMapping(value = "/software/{id}")
    public ModelAndView soft_dele(@PathVariable(value="id")String id,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        softwareService.delete(id);
        PageHelper.startPage(pageNum,10);
        List<Software> recent = softwareService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent",recent);
        PageInfo<Software> pageInfo = new PageInfo<Software>(recent);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("software");
        return modelAndView;
    }
    @RequestMapping(value = "/software_dele")
    public ModelAndView soft_deleSelector(String[] item,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        for (String string : item) {
            softwareService.delete(string);
        }
        PageHelper.startPage(pageNum,10);
        List<Software> recent = softwareService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent",recent);
        PageInfo<Software> pageInfo = new PageInfo<Software>(recent);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("software");
        return modelAndView;
    }
    @RequestMapping(value = "/software_add")
    public ModelAndView soft_add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("software_add");
        return modelAndView;
    }
    @RequestMapping(value = "/softinsert",produces = "text/html;charset=UTF-8")
    public ModelAndView softinsert(Software software,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        softwareService.add(software);
        PageHelper.startPage(pageNum, 10);
        List<Software> recent = softwareService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent", recent);
        PageInfo<Software> pageInfo = new PageInfo<Software>(recent);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("software");
        return modelAndView;
    }

    @RequestMapping(value = "/userdata")
    public ModelAndView userdata(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,12);
        List<Userdata> recent = userdataService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent",recent);
        PageInfo<Userdata> pageInfo = new PageInfo<Userdata>(recent);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("userdata");
        return modelAndView;
    }
    @RequestMapping(value = "/userdata/{id}")
    public ModelAndView user_dele(@PathVariable(value="id")String id,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        userdataService.delete(id);
        PageHelper.startPage(pageNum,10);
        List<Userdata> recent = userdataService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent",recent);
        PageInfo<Userdata> pageInfo = new PageInfo<Userdata>(recent);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("userdata");
        return modelAndView;
    }
    @RequestMapping(value = "/userdata_dele")
    public ModelAndView user_deleSelector(String[] item,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        for (String string : item) {
            userdataService.delete(string);
        }
        PageHelper.startPage(pageNum,10);
        List<Userdata> recent = userdataService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent",recent);
        PageInfo<Userdata> pageInfo = new PageInfo<Userdata>(recent);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("userdata");
        return modelAndView;
    }
    @RequestMapping(value = "/userdata_add")
    public ModelAndView user_add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userdata_add");
        return modelAndView;
    }
    @RequestMapping(value = "/userinsert",produces = "text/html;charset=UTF-8")
    public ModelAndView userinsert(Userdata userdata,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        userdataService.add(userdata);
        PageHelper.startPage(pageNum, 10);
        List<Userdata> recent = userdataService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recent", recent);
        PageInfo<Userdata> pageInfo = new PageInfo<Userdata>(recent);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("userdata");
        return modelAndView;
    }

    @RequestMapping(value = "/id_1")
    public ModelAndView id1() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ID1");

        return modelAndView;
    }
    @RequestMapping(value = "/id_2")
    public ModelAndView id2() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ID2");

        return modelAndView;
    }
    @RequestMapping(value = "/id_3")
    public ModelAndView id3() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ID3");

        return modelAndView;
    }
    @RequestMapping(value = "/id_4")
    public ModelAndView id4() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ID4");

        return modelAndView;
    }
    @RequestMapping(value = "/id_5")
    public ModelAndView id5() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ID5");

        return modelAndView;
    }
    @RequestMapping(value = "/index11")
    public ModelAndView index11() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index11.8");

        return modelAndView;
    }




    /**
     * 登录
     *
     * @param loginDTO
     * @return token登录凭证
     */
    @RequestMapping("/oceanlogin")
    public ModelAndView login(LoginDTO loginDTO, HttpServletRequest request,HttpServletResponse response){

        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        //用户信息
        OceanUser user = oceanUserService.findByUsername(username);
        //账号不存在、密码错误
        System.out.println(user);
        System.out.println(password);
        System.out.println(user.getPassword());
        System.out.println(user.getPassword().equals(password));
        if (user == null || !user.getPassword().equals(password)) {
            //return Result.build(400, "用户名或密码错误");
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("default");
            return modelAndView;
        } else {
            //生成token，并保存到数据库
            String token = oceanUserService.createToken(user);
            System.out.println(token);
            TokenVO tokenVO = new TokenVO();
            tokenVO.setToken(token);
            //return Result.ok(tokenVO);
            Result.ok(tokenVO);
            Mutil mutil = mutilService.findRecent();
            Mutil mutil2 = mutilService.complier(mutil);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("mutil",mutil);
            modelAndView.addObject("mutil2",mutil2);
            //modelAndView.addObject("username",username);
            //modelAndView.addObject("token",password);
            //modelAndView.addObject("token",token);
            //modelAndView.addObject("username",username);
            modelAndView.setViewName("index11.8");
            String cookieName="token";
            String cookieusername="username";
            String cookiepassword="password";
            String value = token;
            String value1 = username;
            String value2= password;
            Cookie cookie=new Cookie(cookieName, value);
            Cookie cookie1=new Cookie(cookieusername, value1);
            Cookie cookie2=new Cookie(cookiepassword, value2);
            cookie.setMaxAge(20); //存活期为1天
            cookie1.setMaxAge(24*60*60); //存活期为1天
            cookie2.setMaxAge(24*60*60); //存活期为1天
            response.addCookie(cookie);
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            return modelAndView;

        }
    }
    @RequestMapping("/optimization")
    public ModelAndView optimization() {
        Mutil mutil = mutilService.findRecent();
        Mutil computercompiler = mutilService.computercompiler(mutil);
        Mutil mutil_139 = mutilService.findRecent_139();
        Mutil mutil_149 = mutilService.findRecent_149();
        Mutil mutil_150 = mutilService.findRecent_150();
        Mutil mutil_152 = mutilService.findRecent_152();
        String cpsocre_139=mutilService.computerScore(mutil_139,8,16);
        String cpsocre_149=mutilService.computerScore(mutil_149,8,16);
        String cpsocre_150=mutilService.computerScore(mutil_150,8,64);
        String cpsocre_151=mutilService.computerScore(mutil,16,64);
        String cpsocre_152=mutilService.computerScore(mutil_152,4,16);
        String iosocre_139=mutilService.ioScore(mutil_139,8,16);
        String iosocre_149=mutilService.ioScore(mutil_149,8,16);
        String iosocre_150=mutilService.ioScore(mutil_150,8,64);
        String iosocre_151=mutilService.ioScore(mutil,16,64);
        String iosocre_152=mutilService.ioScore(mutil_152,4,16);
        ArrayList<String> lsit1 = new ArrayList<>();
        ArrayList<String> lsit2 = new ArrayList<>();
        lsit1.add(cpsocre_139);
        lsit1.add(cpsocre_149);
        lsit1.add(cpsocre_150);
        lsit1.add(cpsocre_151);
        lsit1.add(cpsocre_152);
        int top1 = mutilService.top(lsit1);
        lsit2.add(iosocre_139);
        lsit2.add(iosocre_149);
        lsit2.add(iosocre_150);
        lsit2.add(iosocre_151);
        lsit2.add(iosocre_152);
        int top2 = mutilService.top(lsit2);
        int recommend=mutilService.recommend(computercompiler,top1,top2);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("mutil",mutil);
        modelAndView.addObject("mutil_139",mutil_139);
        modelAndView.addObject("mutil_149",mutil_149);
        modelAndView.addObject("mutil_150",mutil_150);
        modelAndView.addObject("mutil_152",mutil_152);
        modelAndView.addObject("computercompiler",computercompiler);
        modelAndView.addObject("cpsocre_139",cpsocre_139);
        modelAndView.addObject("cpsocre_149",cpsocre_149);
        modelAndView.addObject("cpsocre_150",cpsocre_150);
        modelAndView.addObject("cpsocre_151",cpsocre_151);
        modelAndView.addObject("cpsocre_152",cpsocre_152);
        modelAndView.addObject("iosocre_139",iosocre_139);
        modelAndView.addObject("iosocre_149",iosocre_149);
        modelAndView.addObject("iosocre_150",iosocre_150);
        modelAndView.addObject("iosocre_151",iosocre_151);
        modelAndView.addObject("iosocre_152",iosocre_152);
        modelAndView.addObject("top1",top1);
        modelAndView.addObject("top2",top2);
        modelAndView.addObject("recommend",recommend);


        modelAndView.setViewName("optimization");
        return modelAndView;
    }


    /**
     * 登出
     *
     * @param
     * @return
     */
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        //从request中取出token
        String token = TokenUtil.getRequestToken(request);
        oceanUserService.logout(token);
        return Result.ok();
    }

    @RequestMapping("/oceanuserinsert")
    public ModelAndView ouinsert(OceanUser oceanUser) {
        //从request中取出token

        oceanUserService.insert(oceanUser);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Ocean_login");
        return modelAndView;
    }


    /**
     * 测试
     *
     * @param
     * @return
     */
    @PostMapping("/oceantest")
    public Result test(String token) {
        return Result.ok("恭喜你，验证成功啦，我可以返回数据给你");
    }





}
