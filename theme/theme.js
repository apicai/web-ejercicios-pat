(function(global) {

  // Class names of questions and tasks
  const taskStyles = ['checked', 'unchecked'];
  const questionStyles = ['answer', 'question'];

  // To remember completed steps and answers
  function save(id, value) { global.localStorage && global.localStorage.setItem(id, value); }
  function read(id) { return global.localStorage && global.localStorage.getItem(id); }
  // Avoid hidden text in textareas with scroll
  function fitContent(element) {
    element.style.height = "5px";
    element.style.height = (element.scrollHeight)+"px";
  }
  // Selectors of the main UI elements
  function toggleListItem(className) {
    Array.from(global.document.querySelectorAll('li.' + className)).forEach(li => li.onclick(true));
  }
  function getListItems() { return Array.from(global.document.querySelectorAll('li > input[type="checkbox"]')); }
  function getTaskList() { return global.document.querySelector('task-list'); }

  // Custom tag as web component
  global.customElements.define('task-list', class extends HTMLElement {
    constructor() {
      super();
      this.innerHTML = `
        <a id="unmark-all" title="Marcar todos incompletos" aria-label="Marcar todos incompletos"><i>✘</i></a>
        <a id="mark-all" title="Marcar todos completos" aria-label="Marcar todos completos"><i>✔</i></a>
        <span id="tasks-title"></span>
        <a id="print-page" title="Entregar" aria-label="Entregar"><i class="fa fa-print"></i></a>
      `;
    }
    get title() { return this.getAttribute('title'); }
    set title(val) { val ? this.setAttribute('title', '') : this.removeAttribute('title'); }
    connectedCallback() {
      global.document.getElementById("unmark-all").onclick = () => toggleListItem(questionStyles[0]) || toggleListItem(taskStyles[0]);
      global.document.getElementById("mark-all").onclick = () => toggleListItem(questionStyles[1]) || toggleListItem(taskStyles[1]);
      global.document.getElementById("print-page").onclick = () => global.print();
      this.updateTitle();
    }
    updateTitle() {
      const tasks = getListItems();
      const completed = tasks.map(t => read(t.id) ? 1 : 0).reduce((total, i) => total + i);
      global.document.getElementById("tasks-title").textContent = this.title + `: completado ${completed} de ${tasks.length}`;
    }
  });

  // Highlight footnotes
  global.onhashchange = function() { 
    Array.from(global.document.querySelectorAll('.footnote-definition')).forEach(e => 
      e.id === global.location.hash.substring(1) ? 
      e.classList.add("highlight") || e.classList.remove("lowlight") :
      e.classList.remove("highlight") || e.classList.add("lowlight")
    );
  }

  // Doc title -> PDF file title
  global.onbeforeprint = function() {
    toggleListItem(questionStyles[1]);
    const originalTitle = global.document.title;
    global.document.title = (getTaskList() || {}).title || originalTitle;
    global.onafterprint = function() { global.document.title = originalTitle; };
    global.navigator.clipboard && global.navigator.clipboard.writeText(global.document.title + ".pdf");
  }

  // Create the tasks and questions list
  getListItems().forEach(i => { 
    const li = i.parentElement;
    i.id = global.location.pathname + Array.from(li.parentNode.children).indexOf(li);
    i.disabled = false;
    i.style.display = 'none';

    (li.onclick = (e) => { 
      if (e && e.target && e.clientX - e.target.getBoundingClientRect().left > 0) return;
      const styles = li.innerText.endsWith('?') ? questionStyles : taskStyles;
      i.checked = e ? !i.checked : (read(i.id) || i.checked);
      li.className = i.checked ? styles[0] : styles[1];
      styles === taskStyles && save(i.id, i.checked ? i.checked : "");
      const taskList = getTaskList();
      (getTaskList() || {updateTitle: ()=>{}}).updateTitle();
    })();

    if (questionStyles.includes(li.className)) {
      const textarea = global.document.createElement("textarea");
      textarea.oninput = () => fitContent(textarea) || save(i.id, textarea.value);
      textarea.value = read(i.id);
      ['br','hr'].includes(li.lastElementChild.nodeName.toLocaleLowerCase()) ?
        li.insertBefore(textarea, li.lastElementChild) :
        li.appendChild(textarea);
      textarea.value && textarea.oninput();
    }
  });

  // Open external links in a new tab
  Array.from(global.document.querySelectorAll("a[href^=http]:not(a[title])")).forEach(a => {
    const link = global.document.createElement("a");
    a.innerHTML += '<i class="fa fa-external-link" title="Abre en una pestaña nueva" style="font-size:0.7em;padding-left:0.7ch;"></i>';
    a.target = "_blank";
    link.title = "Abre en una pestaña nueva";
  });

  // Add Codepen.io fill embeds script
  const script = document.createElement('script');
  script.src = "https://static.codepen.io/assets/embed/ei.js";
  document.body.appendChild(script);

})(this);